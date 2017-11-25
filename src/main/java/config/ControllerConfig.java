package config;

import method.Method;

/**
 * Created by Linuxea on 17-11-25.
 */

public abstract class ControllerConfig {

    /**
     * 建立 controller 与 url 的映射关系
     * @param url
     */
    public abstract void connect(String url, Class<? extends Method> clazz);

}
