package com.linuxea.mvc.method;

import com.linuxea.mvc.data.AbstractResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * abstract method
 * @author linuxea
 * @date 2017-11-25
 */

public abstract class AbstractMethod<T extends AbstractResponse> {

    /**
     * method type validate
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public abstract void validateType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    /**
     * subclass service do
     * must override
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public abstract T doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
