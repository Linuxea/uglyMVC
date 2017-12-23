package com.linuxea.mvc.method.test;

import com.linuxea.mvc.annotations.data.Text;
import com.linuxea.mvc.method.AbstractGetMethod;

/**
 * @author linuxea
 * @date 17-11-28
 **/
@Text
public class GetMethodTest extends AbstractGetMethod<String> {
    
    @Override
    public String doIt() {
        return "今天是个好日子呀好呀好日子呢";
    }
}
