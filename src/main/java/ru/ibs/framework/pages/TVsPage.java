package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TVsPage extends BasePage {

    public static final String NAMEPAGE = "TVsPage";

    @FindBy(xpath = "//div[@data-grabber='SearchTitle']")
    private WebElement title;

    @FindBy(xpath = "//span[text()='Все фильтры']")
    private WebElement allFiltersButton;

    public TVsPage checkOpenTVsPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }

    public AllFiltersPage clickAllFiltersButton() {
        waitElementToBeClickable(allFiltersButton).click();
        return app.getAllFiltersPage();
    }

}
