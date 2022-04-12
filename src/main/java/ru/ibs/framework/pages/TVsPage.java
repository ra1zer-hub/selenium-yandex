package ru.ibs.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.entities.Values;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TVsPage extends BasePage {

    public static final String NAMEPAGE = "TVsPage";

    @FindBy(xpath = "//div[@data-grabber='SearchTitle']")
    private WebElement title;

    @FindBy(xpath = "//button[contains(@id, 'dropdown-control-')]")
    private WebElement amountOfElements;

    @FindBy(xpath = "//div[contains(@aria-labelledby, 'dropdown-control-')]")
    private WebElement amountOfElementsOptions;

    @FindBy(xpath = "//article[@data-autotest-id='product-snippet']")
    private List<WebElement> productList;

    @FindBy(id = "header-search")
    private WebElement searchInput;


    public TVsPage checkOpenTVsPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName), "Страница не открылась/открылась не правильная страница");
        return this;
    }

    public TVsPage checkAmountOfElements(String amount) {
        assertTrue(amount.equals("12") || amount.equals("48"), "Не правильно задано количество. Возможные варианты 12 или 48");
        WebElement amountOfElementsText = amountOfElements.findElement(By.xpath("./span"));
        if (!amountOfElementsText.getText().trim().equalsIgnoreCase("Показывать по " + amount)) {
            waitElementToBeClickable(amountOfElements).click();
            WebElement selectAmountOfElements = amountOfElementsOptions.findElement(By.xpath(String.format(".//button[text()='Показывать по %s']", amount)));
            waitElementToBeClickable(selectAmountOfElements).click();
            sleep(5);
        }
        assertEquals(amount, String.valueOf(productList.size()), "Элементов на странице не равно " + amount);
        return this;
    }

    public TVsPage rememberElement(int elementNumber, String varName) {
        WebElement productTitle = productList.get(elementNumber - 1).findElement(By.xpath(".//h3[@data-zone-name='title']"));
        saveElement(productTitle, varName);
        return this;
    }

    public SearchingResultsPage searchElement(String varName) {
        fillSearchField(searchInput, Values.getValues().get(varName));
        return app.getSearchingResultsPage();
    }

}
