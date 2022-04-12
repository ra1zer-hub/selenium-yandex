package ru.ibs.framework.entities;

import java.util.HashMap;
import java.util.Map;

public class Values {

    private static Map<String, String> values = new HashMap<>();

    public static Map<String, String> getValues() {
        return values;
    }

    public static void clearValues() {
        values.clear();
    }

}
