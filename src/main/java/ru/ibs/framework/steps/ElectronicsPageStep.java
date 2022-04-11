package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class ElectronicsPageStep {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^на странице электроники выбрать раздел \"(.*)\"$")
    public void selectSection(String sectionName) {
        pagesManager.getElectronicsPage().selectMenuSection(sectionName);
    }
}
