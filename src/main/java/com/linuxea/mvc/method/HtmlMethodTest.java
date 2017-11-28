package com.linuxea.mvc.method;

import com.linuxea.mvc.data.HtmlData;

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
