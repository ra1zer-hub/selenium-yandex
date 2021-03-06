package ru.ibs.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectronicsPage extends BasePage {

    public static final String NAMEPAGE = "ElectronicsPage";

    @FindBy(tagName = "h1")
    private WebElement title;

    public ElectronicsPage checkOpenElectronicsPage(String pageName) {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains(pageName),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }


}
