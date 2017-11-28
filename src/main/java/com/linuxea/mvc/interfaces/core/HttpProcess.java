package com.linuxea.mvc.interfaces.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linuxea
 * @date 17-11-29
 */
@FunctionalInterface
public interface HttpProcess {

    /**
     * request response process
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
