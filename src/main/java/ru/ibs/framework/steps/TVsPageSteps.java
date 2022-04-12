package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class TVsPageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^проверить, что элементов на странице \"(\\d+)\"$")
    public void clickCreateBusinessTrips(String amount) {
        pagesManager.getTVsPage().checkAmountOfElements(amount);
    }

    @И("^сохранить название товар № \"(\\d+)\" в переменной \"(.*)\"$")
    public void rememberElement(int elementNumber, String varName) {
        pagesManager.getTVsPage().rememberElement(elementNumber, varName);
    }

    @И("^ввести в поисковую строку значение из переменной \"(.*)\"$")
    public void rememberElement(String varName) {
        pagesManager.getTVsPage().searchElement(varName);
    }
}
