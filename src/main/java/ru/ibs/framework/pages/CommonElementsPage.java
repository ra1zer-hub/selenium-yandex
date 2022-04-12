package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class CommonElementsPage extends BasePage {

    public static final String NAMEPAGE = "CommonElementsPage";

    @FindBy(xpath = "//span[text()='Все фильтры']")
    private WebElement allFiltersButton;

    @FindBy(xpath = "//div[contains(@data-zone-data,'/catalog--')]")
    private List<WebElement> listMenuSection;

    public AllFiltersPage clickAllFiltersButton() {
        waitElementToBeClickable(allFiltersButton).click();
        return app.getAllFiltersPage();
    }

    public BasePage selectMenuSection(String sectionName) {
        for (WebElement menuItem : listMenuSection) {
            if (menuItem.getText().trim().equalsIgnoreCase(sectionName)) {
                waitElementToBeClickable(menuItem).click();
                switch (sectionName) {
                    case "Телевизоры":
                        return app.getTVsPage();
                    case "Наушники и аудиотехника":
                        return app.getHeadphonesAndAudioEquipmentPage();
                    case "Наушники и Bluetooth-гарнитуры":
                        return app.getHeadphonesAndBluetoothHeadsetsPage();
                    default:
                        fail("Не правильно указано название раздела");
                }
            }
        }
        fail("Раздел '" + sectionName + "' не найден");
        return this;
    }

}
