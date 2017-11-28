package com.linuxea.mvc.method;

import com.linuxea.mvc.data.ImageData;

/**
 * @author linuxea
 * @date 17-11-28
 **/
@ImageData
public class ImageDataTest extends AbstractGetMethod {
    @Override
    public Object doIt() {
        return "/home/linuxea/Desktop/ok.jpg";
    }
}
