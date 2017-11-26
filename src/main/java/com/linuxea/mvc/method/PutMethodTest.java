package com.linuxea.mvc.method;

import com.linuxea.mvc.data.AbstractResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Linuxea on 17-11-25.
 */

public class PutMethodTest extends AbstractPutMethod {
    @Override
    public AbstractResponse doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().write("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
