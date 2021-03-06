package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class HeadphonesAndAudioEquipmentPage extends BasePage {

    public static final String NAMEPAGE = "HeadphonesAndAudioEquipmentPage";

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(xpath = "//div[contains(@data-zone-data,'/catalog--')]")
    private List<WebElement> listMenuSection;

    public HeadphonesAndAudioEquipmentPage checkOpenHeadphonesAndAudioEquipmentPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }

    public BasePage selectMenuSection(String sectionName) {
        for (WebElement menuItem : listMenuSection) {
            if (menuItem.getText().trim().equalsIgnoreCase(sectionName)) {
                waitElementToBeClickable(menuItem).click();
                return app.getTVsPage();
            }
        }
        fail("Раздел '" + sectionName + "' не найден");
        return app.getTVsPage();
    }
}
