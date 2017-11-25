package method;

import data.ResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Linuxea on 17-11-25.
 */

public class MethodTest extends GetMethod {

    @Override
    public ResponseData doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().write("this is very interesting");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
