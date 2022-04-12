package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class SearchingResultsPageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^найти товар с названием \"(.*)\"$")
    public void rememberElement(String varName) {
        pagesManager.getSearchingResultsPage().findProduct(varName);
    }
}
