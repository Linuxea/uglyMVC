package com.linuxea.mvc.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * abstract class response data status
 * @author linuxea
 * @date 2017-11-25
 */

public abstract class AbstractResponse {

    /**
     * process do
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public abstract void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
