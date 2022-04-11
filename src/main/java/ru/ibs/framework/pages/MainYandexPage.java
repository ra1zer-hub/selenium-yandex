package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class MainYandexPage extends BasePage {

    public static final String NAMEPAGE = "MainYandexPage";

    @FindBy(xpath = "//a[contains(@class, 'home-link services-new__item')]")
    private List<WebElement> listMenu;

    public MainMarketPage selectMenu(String menuName) {
        for (WebElement menuItem : listMenu) {
            if (menuItem.getText().trim().equalsIgnoreCase(menuName)) {
                waitElementToBeClickable(menuItem).click();
                return app.getMainMarketPage();
            }
        }
        fail("Меню '" + menuName + "' не найдено");
        return app.getMainMarketPage();
    }

}
