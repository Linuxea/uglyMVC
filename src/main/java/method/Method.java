package method;

import data.ResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Linuxea on 17-11-25.
 */

public interface Method<T extends ResponseData> {

    T doIt(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
