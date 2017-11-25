package com.linuxea.mvc.method;

import com.linuxea.mvc.data.ResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * abstract method
 * Created by Linuxea on 17-11-25.
 */

public abstract class Method<T extends ResponseData> {

    public abstract void validateType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    public abstract T doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
