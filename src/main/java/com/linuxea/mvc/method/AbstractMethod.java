package com.linuxea.mvc.method;

import com.linuxea.mvc.data.JsonData;
import com.linuxea.mvc.data.StringData;
import com.linuxea.mvc.data.XmlData;
import com.linuxea.mvc.exception.NotSupportResponseDataFormaException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.AnnotatedType;

/**
 * abstract method
 * @author linuxea
 * @date 2017-11-25
 */

public abstract class AbstractMethod<T> {

    /**
     * method type validate
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public abstract void validateType(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    /**
     * subclass service do
     * must override
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public abstract T doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    /**
     * method logic
     *
     * @param httpServletRequest
     * @param httpServletResponse
     */
    public final void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.validateType(httpServletRequest, httpServletResponse);
        T t = this.doIt(httpServletRequest, httpServletResponse);
        AnnotatedType[] annotatedInterfaces = this.getClass().getAnnotatedInterfaces();
        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
            if (annotatedInterface.isAnnotationPresent(JsonData.class)) {

            } else if (annotatedInterface.isAnnotationPresent(XmlData.class)) {

            } else if (annotatedInterface.isAnnotationPresent(StringData.class)) {

            } else {
                throw new NotSupportResponseDataFormaException("not support response data format");
            }
        }
    }

}
