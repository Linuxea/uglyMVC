package com.linuxea.mvc.method;

import com.linuxea.mvc.data.TextData;

/**
 * @author linuxea
 * @date 17-11-28
 **/
@TextData
public class GetMethodTest extends AbstractGetMethod {

    @Override
    public Object doIt() {
        return "今天是个好日子呀好呀好日子呢";
    }
}
