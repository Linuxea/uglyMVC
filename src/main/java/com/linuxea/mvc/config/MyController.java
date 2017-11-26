package com.linuxea.mvc.config;

import com.linuxea.mvc.method.AbstractGetMethodTest;
import com.linuxea.mvc.method.PutMethodTest;

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
        super.add("/shit", PutMethodTest.class);
    }
}
