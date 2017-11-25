package com.linuxea.mvc.constant;

/**
 * http method constants
 * Created by Linuxea on 17-11-25.
 */

public enum MethodTypeEnum {

    GET("get"), PUT("put"), POST("post"), DELETE("delete"), PATCH("patch");

    String aliasName;

    MethodTypeEnum(String aliasName) {
        this.aliasName = aliasName;
    }

}
