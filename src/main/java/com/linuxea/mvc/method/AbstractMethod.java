package com.linuxea.mvc.method;

import com.linuxea.mvc.data.JsonData;
import com.linuxea.mvc.data.StringData;
import com.linuxea.mvc.data.XmlData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

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
        System.out.println(this);
        // "this" is the abstract method instance
        Annotation[] annotations = this.getClass().getAnnotations();
        boolean skip = true;
        for (int i = 0; i < annotations.length; i++) {
            Annotation annotation = annotations[i];
            if (annotation.annotationType() == JsonData.class) {

            } else if (annotation.annotationType() == StringData.class) {

            } else if (annotation.annotationType() == XmlData.class) {

            } else {
                skip = false;
            }

            if (skip) {
                break;
            }
        }
    }

}
