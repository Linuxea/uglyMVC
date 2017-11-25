package com.linuxea.mvc.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * abstract class response data status
 * Created by Linuxea on 17-11-25.
 */

public abstract class ResponseData {

    public abstract void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
