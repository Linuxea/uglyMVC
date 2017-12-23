package com.linuxea.mvc.method.test;

import com.linuxea.mvc.annotations.data.Json;
import com.linuxea.mvc.method.AbstractGetMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * demo
 *
 * @author linuxea
 * @date 2017-11-25
 */
@Json
public class AbstractGetMethodTest extends AbstractGetMethod<Map<String, String>> {
	
	@Override
	public Map<String, String> doIt() {
		Map<String, String> map = new HashMap<>(5);
		map.put("name", "linuxea");
		map.put("age", "12");
		map.put("sex", "boy");
		return map;
	}
}
