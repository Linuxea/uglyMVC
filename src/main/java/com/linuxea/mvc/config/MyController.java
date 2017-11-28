package com.linuxea.mvc.config;

import com.linuxea.mvc.method.AbstractGetMethodTest;
import com.linuxea.mvc.method.GetMethodTest;
import com.linuxea.mvc.method.HtmlMethodTest;
import com.linuxea.mvc.method.ImageDataTest;

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
        super.add("/hi", GetMethodTest.class);
        super.add("/bye", HtmlMethodTest.class);
        super.add("/bibi", ImageDataTest.class);
    }
}
