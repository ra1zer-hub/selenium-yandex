package ru.ibs.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static ru.ibs.framework.managers.InitManager.initFramework;
import static ru.ibs.framework.managers.InitManager.quitFramework;
import static ru.ibs.framework.managers.PagesManager.pagesIsNull;

public class Hooks {

    @Before
    public static void before() {
        initFramework();
    }

//    @After
//    public static void after() {
//        pagesIsNull();
//        quitFramework();
//    }
}
