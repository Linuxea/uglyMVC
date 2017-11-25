package com.linuxea.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Linuxea on 17-11-25.
 */

public class SystemInit extends Project {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemInit.class);

    @Override
    public void init() {
        new MyController().connect();
        LOGGER.info("controller 映射成功");
    }
}
