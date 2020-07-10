package com.haizhi.template.config.exception;

import lombok.Data;

/**
 * Create by liu·yu
 * Date is 2019-11-13
 * Description is : 自定义异常，用于程序出错时抛出
 */
@Data
public class CustomServerException extends Exception {

    private int code;

    private String message;

    private Object data;

    public CustomServerException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public CustomServerException(int code, String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
