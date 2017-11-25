package com.linuxea.mvc;

import com.linuxea.mvc.config.AbstractControllerConfig;
import com.linuxea.mvc.config.SystemInit;
import com.linuxea.mvc.method.AbstractMethod;
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
 * @author linuxea
 * @date 2017-11-25
 **/
public class DispatcherServlet extends HttpServlet {

    /**
     * 用来缓存 method 对象的实例
     */
    private static final Map<Class, AbstractMethod> MAP = new HashMap<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServlet.class);
    /**
     * 对象映射关系的获取
     */
    private static final Map<String, Class<? extends AbstractMethod>> CONTROLLER_MAPPING_MAP = AbstractControllerConfig.getMap();

    {
        dispatcherInit();
    }

    public DispatcherServlet() {
        // only init once
        LOGGER.info("dispatcherServlet init successfully");
    }

    /**
     * service dispatcher center
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        String uri = httpServletRequest.getRequestURI().toString();
        AbstractMethod method;
        try {
            Class<? extends AbstractMethod> inst = CONTROLLER_MAPPING_MAP.get(uri);
            if (null != inst) {
                if (null != MAP.get(inst)) {
                    method = MAP.get(inst);
                } else {
                    method = inst.newInstance();
                    MAP.put(inst, method);
                }
                method.process(httpServletRequest, httpServletResponse);
            } else {
                httpServletResponse.getWriter().write("not this url mapping");
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * some thing init
     */
    public void dispatcherInit() {
        new SystemInit().init();
    }

}
