package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class AllFiltersPageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^указать цену от \"(\\d*)\" до \"(\\d*)\"$")
    public void setPrice(String minPrice, String maxPrice) {
        pagesManager.getAllFiltersPage().setPrice(minPrice, maxPrice);
    }

    @И("^выбрать производителя \"(.*)\"$")
    public void setPrice(String value) {
        pagesManager.getAllFiltersPage().selectManufacturer(value);
    }

}
