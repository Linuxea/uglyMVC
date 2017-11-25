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
import java.util.Map;

/**
 * dispatcher servlet
 * create by linuxea on 17-11-23
 **/
public class DispatcherServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);

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
        Map<String, Class<? extends Method>> map = ControllerConfig.getMap();
        Method method;
        try {
            Class<? extends Method> inst = map.get(uri);
            if (null != inst) {
                method = inst.newInstance();
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
