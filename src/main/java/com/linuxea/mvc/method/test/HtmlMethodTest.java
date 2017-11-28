package com.linuxea.mvc.method.test;

import com.linuxea.mvc.annotations.data.HtmlData;
import com.linuxea.mvc.method.AbstractGetMethod;

/**
 * @author linuxea
 * @date 17-11-28
 **/
@HtmlData
public class HtmlMethodTest extends AbstractGetMethod {

    @Override
    public Object doIt() {
        return "<html><head>hello</head><title>thisisatile</title><body><p>hello this is from server</p></body></html>";
    }
}
