package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class TVsPageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^кликнуть на кнопку 'Все фильтры'$")
    public void clickAllFiltersButton() {
        pagesManager.getTVsPage().clickAllFiltersButton();
    }

}
