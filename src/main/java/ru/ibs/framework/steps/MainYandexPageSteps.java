package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

public class MainYandexPageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^в верхнем меню нажимаем на \"(.*)\"$")
    public void clickCreateBusinessTrips(String menuName) {
        pagesManager.getMainYandexPage().selectMenu(menuName);
    }
}
