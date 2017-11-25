package com.linuxea.mvc.config;

import com.linuxea.mvc.method.MethodTest;

/**
 * Created by Linuxea on 17-11-25.
 */

public class MyController extends ControllerConfig {

    /**
     * url -> controller mapping
     */
    @Override
    public void connect() {
        super.add("/hello", MethodTest.class);
    }
}
