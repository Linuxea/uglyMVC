package com.linuxea.mvc.config;

import com.linuxea.mvc.method.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * url -> controller
 * Created by Linuxea on 17-11-25.
 */

public abstract class ControllerConfig {

    private static Map<String, Class<? extends Method>> map = new HashMap<>();

    public static Map<String, Class<? extends Method>> getMap() {
        return map;
    }

    public static void setMap(Map<String, Class<? extends Method>> map) {
        ControllerConfig.map = map;
    }

    protected void add(String url, Class<? extends Method> method) {
        map.put(url, method);
    }

    public abstract void connect();
}
