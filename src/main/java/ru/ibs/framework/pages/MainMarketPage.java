package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MainMarketPage extends BasePage {

    public static final String NAMEPAGE = "MainMarketPage";

    @FindBy(id = "logoPartMarket")
    private WebElement title;

    @FindBy(xpath = "//div[@data-auto='yandexPlusPromoTooltip']")
    private WebElement promo;

    @FindBy(xpath = "//div[@data-zone-name='category-link']")
    private List<WebElement> listMenuSection;

    public MainMarketPage checkOpenMainMarketPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }

    public MainMarketPage closePromo() {
        promoClose(promo);

        return this;
    }

    public MainMarketPage selectMenuSection(String sectionName) {
        for (WebElement menuItem : listMenuSection) {
            if (menuItem.getText().trim().equalsIgnoreCase(sectionName)) {
                waitElementToBeClickable(menuItem).click();
                return app.getMainMarketPage();
            }
        }
        fail("Раздел '" + sectionName + "' не найден");
        return app.getMainMarketPage();
    }

}
