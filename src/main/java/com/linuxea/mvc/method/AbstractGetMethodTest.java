package com.linuxea.mvc.method;

import com.linuxea.mvc.data.JsonData;

import java.util.HashMap;
import java.util.Map;

/**
 * demo
 * @author linuxea
 * @date 2017-11-25
 */

@JsonData
public class AbstractGetMethodTest extends AbstractGetMethod {

    /**
     * test demo
     */
    @Override
    public Object doIt() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "linuxea");
        map.put("age", "12");
        map.put("sex", "boy");
        return map;
    }

}
