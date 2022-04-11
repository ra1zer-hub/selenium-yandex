package ru.ibs.framework.steps;

import io.cucumber.java.ru.И;
import ru.ibs.framework.managers.PagesManager;

import static org.junit.jupiter.api.Assertions.fail;

public class BasePageSteps {

    PagesManager pagesManager = PagesManager.getManagerPages();

    @И("^открылась страница \"(.*)\"$")
    public void checkOpenPage(String pageName) {
        switch (pageName) {
            case "Маркет":
                pagesManager.getMainMarketPage().checkOpenMainMarketPage(pageName);
                break;
            case "Электроника":
                pagesManager.getElectronicsPage().checkOpenElectronicsPage(pageName);
                break;
            case "Телевизоры":
                pagesManager.getTVsPage().checkOpenTVsPage(pageName);
                break;
            case "Все фильтры":
                pagesManager.getAllFiltersPage().checkOpenAllFiltersPage(pageName);
                break;
            default:
                fail("Не правильно указано название страницы");
        }
    }
}
