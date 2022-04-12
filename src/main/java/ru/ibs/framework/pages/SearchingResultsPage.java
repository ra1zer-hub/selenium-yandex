package ru.ibs.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.ibs.framework.entities.Values;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SearchingResultsPage extends BasePage {

    public static final String NAMEPAGE = "SearchingResultsPage";

    @FindBy(xpath = "//*[text()='Все результаты поиска']")
    private WebElement title;

    @FindBy(xpath = "//article[@data-autotest-id='product-snippet']")
    private List<WebElement> productList;


    public SearchingResultsPage checkOpenSearchingResultsPage() {
        switchToWindow();
        waitElementToBeVisible(title);
        assertTrue(title.getText().contains("результаты поиска"),
                "Страница не открылась/открылась не правильная страница");
        return this;
    }

    public SearchingResultsPage findProduct(String elementName) {
        String productName = Values.getValues().get(elementName);
        for (WebElement product : productList) {
            WebElement productTitle = product.findElement(By.xpath(".//h3[@data-zone-name='title']"));
            if (productTitle.getText().trim().equalsIgnoreCase(productName)) {
                return app.getSearchingResultsPage();
            }
        }
        fail("Товар '" + productName + "' не найден");
        return app.getSearchingResultsPage();
    }
}
