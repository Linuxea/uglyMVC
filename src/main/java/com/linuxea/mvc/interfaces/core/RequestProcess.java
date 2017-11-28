package com.linuxea.mvc.interfaces.core;

import javax.servlet.http.HttpServletRequest;

/**
 * @author linuxea
 * @date 17-11-29
 */
@FunctionalInterface
public interface RequestProcess {

    /**
     * request process
     *
     * @param httpServletRequest
     */
    void handle(HttpServletRequest httpServletRequest);

}
