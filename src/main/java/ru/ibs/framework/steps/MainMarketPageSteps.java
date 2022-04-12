package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class MainMarketPageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^закрыть промо, если оно есть$")
    public void closePromo() {
        pagesManager.getMainMarketPage().closePromo();
    }

    @И("^на странице маркета выбрать раздел \"(.*)\"$")
    public void selectSection(String sectionName) {
        pagesManager.getMainMarketPage().selectMenuSection(sectionName);
    }
}
