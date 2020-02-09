package com.github.attemper.alarm;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private static Map<Integer, Config> configMap;

    static {
        configMap = new HashMap<Integer, Config>();
    }

    public static Map<Integer, Config> getConfigMap() {
        return configMap;
    }

    public static void setConfigMap(Map<Integer, Config> configMap) {
        Store.configMap = configMap;
    }
}
