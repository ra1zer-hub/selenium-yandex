package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllFiltersPage extends BasePage {

    public static final String NAMEPAGE = "AllFiltersPage";

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix]/input")
    private List<WebElement> price;

    @FindBy(xpath = "//h4[text()='Производитель']/../following-sibling::div//input[not(@type)]")
    private WebElement manufacturer;

    @FindBy(xpath = "//h4[text()='Производитель']/../following-sibling::div//label")
    private WebElement manufacturerCheckBox;

    @FindBy(xpath = "//a[contains(@href, '/catalog--televizory/') and contains(text(),'Показать')]")
    private WebElement showOffersButton;

    public AllFiltersPage checkOpenAllFiltersPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }

    public AllFiltersPage setPrice(String minPrice, String maxPrice) {
        if (!minPrice.isEmpty()) {
            fillInputField(price.get(0), minPrice);
        }
        if (!maxPrice.isEmpty()) {
            fillInputField(price.get(1), maxPrice);
        }
        return this;
    }

    public AllFiltersPage selectManufacturer(String value) {
        fillDateField(manufacturer, value);
        if (manufacturerCheckBox.getText().trim().equalsIgnoreCase(value)) {
            selectCheckbox(manufacturerCheckBox, value);
            return this;
        }
        return this;
    }

    public TVsPage clickShowOffersButton() {
        waitElementToBeClickable(showOffersButton).click();
        return app.getTVsPage();
    }
}
