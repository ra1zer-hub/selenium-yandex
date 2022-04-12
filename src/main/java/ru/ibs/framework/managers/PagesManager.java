package ru.ibs.framework.managers;


import ru.ibs.framework.entities.Values;
import ru.ibs.framework.pages.*;

import java.util.HashMap;
import java.util.Map;

public class PagesManager {

    private static PagesManager pagesManager;
    private static Map<String, BasePage> basePageMap = new HashMap<>();

    private PagesManager() {
    }

    public static PagesManager getManagerPages() {
        if (pagesManager == null) {
            pagesManager = new PagesManager();
        }
        return pagesManager;
    }

    public static void pagesIsNull() {
        basePageMap.clear();
        Values.clearValues();
    }

    public MainYandexPage getMainYandexPage() {
        if (basePageMap.isEmpty() || basePageMap.get(MainYandexPage.NAMEPAGE) == null) {
            basePageMap.put(MainYandexPage.NAMEPAGE, new MainYandexPage());
        }
        return (MainYandexPage) basePageMap.get(MainYandexPage.NAMEPAGE);
    }

    public MainMarketPage getMainMarketPage() {
        if (basePageMap.isEmpty() || basePageMap.get(MainMarketPage.NAMEPAGE) == null) {
            basePageMap.put(MainMarketPage.NAMEPAGE, new MainMarketPage());
        }
        return (MainMarketPage) basePageMap.get(MainMarketPage.NAMEPAGE);
    }

    public ElectronicsPage getElectronicsPage() {
        if (basePageMap.isEmpty() || basePageMap.get(ElectronicsPage.NAMEPAGE) == null) {
            basePageMap.put(ElectronicsPage.NAMEPAGE, new ElectronicsPage());
        }
        return (ElectronicsPage) basePageMap.get(ElectronicsPage.NAMEPAGE);
    }

    public TVsPage getTVsPage() {
        if (basePageMap.isEmpty() || basePageMap.get(TVsPage.NAMEPAGE) == null) {
            basePageMap.put(TVsPage.NAMEPAGE, new TVsPage());
        }
        return (TVsPage) basePageMap.get(TVsPage.NAMEPAGE);
    }

    public AllFiltersPage getAllFiltersPage() {
        if (basePageMap.isEmpty() || basePageMap.get(AllFiltersPage.NAMEPAGE) == null) {
            basePageMap.put(AllFiltersPage.NAMEPAGE, new AllFiltersPage());
        }
        return (AllFiltersPage) basePageMap.get(AllFiltersPage.NAMEPAGE);
    }

    public SearchingResultsPage getSearchingResultsPage() {
        if (basePageMap.isEmpty() || basePageMap.get(SearchingResultsPage.NAMEPAGE) == null) {
            basePageMap.put(SearchingResultsPage.NAMEPAGE, new SearchingResultsPage());
        }
        return (SearchingResultsPage) basePageMap.get(SearchingResultsPage.NAMEPAGE);
    }

    public HeadphonesAndAudioEquipmentPage getHeadphonesAndAudioEquipmentPage() {
        if (basePageMap.isEmpty() || basePageMap.get(HeadphonesAndAudioEquipmentPage.NAMEPAGE) == null) {
            basePageMap.put(HeadphonesAndAudioEquipmentPage.NAMEPAGE, new HeadphonesAndAudioEquipmentPage());
        }
        return (HeadphonesAndAudioEquipmentPage) basePageMap.get(HeadphonesAndAudioEquipmentPage.NAMEPAGE);
    }

    public HeadphonesAndBluetoothHeadsetsPage getHeadphonesAndBluetoothHeadsetsPage() {
        if (basePageMap.isEmpty() || basePageMap.get(HeadphonesAndBluetoothHeadsetsPage.NAMEPAGE) == null) {
            basePageMap.put(HeadphonesAndBluetoothHeadsetsPage.NAMEPAGE, new HeadphonesAndBluetoothHeadsetsPage());
        }
        return (HeadphonesAndBluetoothHeadsetsPage) basePageMap.get(HeadphonesAndBluetoothHeadsetsPage.NAMEPAGE);
    }

    public CommonElementsPage getCommonElementsPage() {
        if (basePageMap.isEmpty() || basePageMap.get(CommonElementsPage.NAMEPAGE) == null) {
            basePageMap.put(CommonElementsPage.NAMEPAGE, new CommonElementsPage());
        }
        return (CommonElementsPage) basePageMap.get(CommonElementsPage.NAMEPAGE);
    }


}
