package com.linuxea.mvc;

import com.linuxea.mvc.config.ControllerConfig;
import com.linuxea.mvc.config.SystemInit;
import com.linuxea.mvc.method.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * dispatcher servlet
 * create by linuxea on 17-11-23
 **/
public class DispatcherServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);

    /**
     * 用来缓存 method 对象的实例
     */
    private static final Map<Class, Method> MAP = new HashMap<>();

    /**
     * 对象映射关系的获取
     */
    private static final Map<String, Class<? extends Method>> controllerMappingMap = ControllerConfig.getMap();

    public DispatcherServlet() {
        // only init once
        init();
        LOGGER.info("dispatcherServlet init successfully");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        String uri = httpServletRequest.getRequestURI().toString();
        Method method;
        try {
            Class<? extends Method> inst = controllerMappingMap.get(uri);
            if (null != inst) {
                if (null != MAP.get(inst)) {
                    method = MAP.get(inst);
                } else {
                    method = inst.newInstance();
                    MAP.put(inst, method);
                }
                method.validateType(httpServletRequest, httpServletResponse);
                method.doIt(httpServletRequest, httpServletResponse);
            } else {
                httpServletResponse.getWriter().write("not this url mapping");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public void init() {
        new SystemInit().init();
    }

}
