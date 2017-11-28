package com.linuxea.mvc.interfaces.core;

import javax.servlet.http.HttpServletResponse;

/**
 * @author linuxea
 * @date 17-11-29
 */
@FunctionalInterface
public interface ResponseProcess {

    /**
     * response process
     *
     * @param httpServletResponse
     */
    void handle(HttpServletResponse httpServletResponse);

}
