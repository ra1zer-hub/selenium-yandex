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
            case "Результаты поиска":
                pagesManager.getSearchingResultsPage().checkOpenSearchingResultsPage();
                break;
            case "Наушники и аудиотехника":
                pagesManager.getHeadphonesAndAudioEquipmentPage().checkOpenHeadphonesAndAudioEquipmentPage(pageName);
                break;
            case "Наушники и Bluetooth-гарнитуры":
            case "Наушники":
                pagesManager.getHeadphonesAndBluetoothHeadsetsPage().checkOpenHeadphonesAndBluetoothHeadsetsPage(pageName);
                break;
            default:
                fail("Не правильно указано название страницы");
        }
    }

    @И("^нажать на кнопку \"(.*)\"$")
    public void clickButton(String buttonName) {
        switch (buttonName) {
            case "Все фильтры":
                pagesManager.getCommonElementsPage().clickAllFiltersButton();
                break;
            case "Показать предложения":
                pagesManager.getAllFiltersPage().clickShowOffersButton();
                break;
            default:
                fail("Не правильно указано название кнопки");
        }
    }

    @И("^выбрать раздел \"(.*)\"$")
    public void selectSection(String sectionName) {
        pagesManager.getCommonElementsPage().selectMenuSection(sectionName);
    }
}
