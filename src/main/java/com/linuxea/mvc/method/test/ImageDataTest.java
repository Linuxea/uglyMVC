package com.linuxea.mvc.method.test;

import com.linuxea.mvc.annotations.data.Img;
import com.linuxea.mvc.method.AbstractGetMethod;

/**
 * @author linuxea
 * @date 17-11-28
 **/
@Img
public class ImageDataTest extends AbstractGetMethod<String> {
    
    @Override
    public String doIt() {
        return "/home/linuxea/Desktop/cat.jpg";
    }
}
