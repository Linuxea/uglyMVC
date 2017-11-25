package com.linuxea.mvc.config;

import com.linuxea.mvc.method.AbstractGetMethodTest;

/**
 * @author linuxea
 * @date 2017-11-25
 */

public class MyController extends AbstractControllerConfig {

    /**
     * url -> controller mapping
     */
    @Override
    public void connect() {
        super.add("/hello", AbstractGetMethodTest.class);
    }
}
