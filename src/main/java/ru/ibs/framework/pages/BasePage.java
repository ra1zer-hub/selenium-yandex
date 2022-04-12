package ru.ibs.framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.ibs.framework.entities.Values;
import ru.ibs.framework.managers.DriverManager;
import ru.ibs.framework.managers.PagesManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasePage {

    protected final DriverManager driverManager = DriverManager.getDriverManager();
    protected JavascriptExecutor js = (JavascriptExecutor) driverManager.getDriver();
    protected PagesManager app = PagesManager.getManagerPages();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(15), Duration.ofSeconds(1));
    protected Select select;

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    protected WebElement scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    protected WebElement waitElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean waitElementIsDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected void fillInputField(WebElement element, String value) {
        scrollToElementJs(element);
        waitElementToBeClickable(element).click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        assertTrue(checkFlag, "Поле было заполнено некорректно");
    }

    protected void fillSelect(WebElement element, String value) {
        select = new Select(element);
        select.selectByVisibleText(value);
        String selectedOption = select.getFirstSelectedOption().getAttribute("text");
        assertEquals(value, selectedOption, "В выпадающем списке не было найдено значение " + value);
    }

    protected void selectCheckbox(WebElement checkbox, String checkboxName) {
        WebElement checkboxButton = checkbox.findElement(By.xpath("./input"));
        if (!checkboxButton.isSelected()) {
            waitElementToBeClickable(checkbox).click();
        }
        assertTrue(checkboxButton.isSelected(), "Чекбокс '" + checkboxName + "' не выбран");
    }

    protected void fillSearchField(WebElement field, String value) {
        waitElementToBeClickable(field).click();
        field.clear();
        field.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(field, "value", value));
        assertTrue(checkFlag, "Поле поиска было заполнено некорректно");
        sleep(3);
        field.sendKeys(Keys.ENTER);
    }

    protected void fillDateField(WebElement element, String value) {
        scrollToElementJs(element);
        waitElementToBeClickable(element).click();
        element.clear();
        element.sendKeys(value);
        boolean checkFlag = wait.until(ExpectedConditions.attributeContains(element, "value", value));
        assertTrue(checkFlag, "Поле было заполнено некорректно");
        element.sendKeys(Keys.ESCAPE);
    }

    protected void promoClose(WebElement element) {
        driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        try {
            if (element.isDisplayed() || element.isEnabled()) {
                WebElement closePromoButton = element.findElement(By.xpath("./following-sibling::button[@data-auto='closer']"));
                waitElementToBeClickable(closePromoButton).click();
            }
        } catch (WebDriverException ignored) {

        } finally {
            driverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
    }

    protected void switchToWindow() {
        for (String winHandle : driverManager.getDriver().getWindowHandles()) {
            driverManager.getDriver().switchTo().window(winHandle);
        }
    }

    protected void saveElement(WebElement productTitle, String varName) {
        Values.getValues().put(varName, productTitle.getText());
    }

    protected void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
