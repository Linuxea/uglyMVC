package com.linuxea.mvc.method;

import com.linuxea.mvc.constant.MethodTypeEnum;
import com.linuxea.mvc.data.ResponseData;
import com.linuxea.mvc.exception.MethodTypeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * put method
 * Created by Linuxea on 17-11-25.
 */

public abstract class PutMethod extends Method<ResponseData> {

    @Override
    public final void validateType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (httpServletRequest.getMethod().equalsIgnoreCase(MethodTypeEnum.PUT.name()) == false) {
            throw new MethodTypeException("com.linuxea.mvc.method type is not put");
        }
    }
}