package com.linuxea.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author linuxea
 * @date 2017-11-25
 */
public class SystemInit extends AbstractProject {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemInit.class);

    @Override
    public void init() {
        new ControllerConfig().connect();
        LOGGER.info("controller 映射成功");
    }
}
