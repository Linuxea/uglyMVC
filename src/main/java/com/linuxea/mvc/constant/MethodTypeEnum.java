package com.linuxea.mvc.constant;

/**
 * http method constants
 * @author linuxea
 * @date 2017-11-25
 */
public enum MethodTypeEnum {

    /**
     * get method
     */
    GET("get"),

    /**
     * put method
     */
    PUT("put"),

    /**
     * post method
     */
    POST("post"),

    /**
     * delete method
     */
    DELETE("delete");

    String aliasName;

    MethodTypeEnum(String aliasName) {
        this.aliasName = aliasName;
    }

}
