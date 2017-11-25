package com.linuxea.mvc.config;

import com.linuxea.mvc.method.AbstractMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * url -> controller
 * @author linuxea
 * @date 2017-11-25
 */

public abstract class AbstractControllerConfig {

    private static Map<String, Class<? extends AbstractMethod>> map = new HashMap<>();

    public static Map<String, Class<? extends AbstractMethod>> getMap() {
        return map;
    }

    public static void setMap(Map<String, Class<? extends AbstractMethod>> map) {
        AbstractControllerConfig.map = map;
    }

    protected void add(String url, Class<? extends AbstractMethod> method) {
        map.put(url, method);
    }

    /**
     * url -> mapping add
     */
    public abstract void connect();
}
