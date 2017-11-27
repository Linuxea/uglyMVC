package com.linuxea.mvc.method;

import com.linuxea.mvc.data.JsonData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * demo
 * @author linuxea
 * @date 2017-11-25
 */

@JsonData
public class AbstractGetMethodTest extends AbstractGetMethod {

    /**
     * test demo
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @Override
    public Object doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().write("this is very interesting");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
