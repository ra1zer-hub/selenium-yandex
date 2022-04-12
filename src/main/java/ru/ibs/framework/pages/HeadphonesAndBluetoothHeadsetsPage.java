package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeadphonesAndBluetoothHeadsetsPage extends BasePage {

    public static final String NAMEPAGE = "HeadphonesAndBluetoothHeadsetsPage";

    @FindBy(xpath = "//div[@data-grabber='SearchTitle']")
    private WebElement title;

    public HeadphonesAndBluetoothHeadsetsPage checkOpenHeadphonesAndBluetoothHeadsetsPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }
}
