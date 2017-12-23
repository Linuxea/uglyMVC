package com.linuxea.mvc.method.test;

import com.linuxea.mvc.annotations.data.Html;
import com.linuxea.mvc.method.AbstractGetMethod;

/**
 * @author linuxea
 * @date 17-11-28
 **/
@Html
public class HtmlMethodTest extends AbstractGetMethod<String> {
	
	@Override
	public String doIt() {
		return "<html><head>hello</head><title>thisisatile</title><body><p>hello this is from server</p></body></html>";
	}
}
