package com.haizhi.template.bean.exception;

import lombok.Data;

/**
 * Create by liuyu
 * Date is 2019-11-13
 * Description is : 自定义异常，用于程序出错时抛出
 */
@Data
public class CustomServerException extends Exception {

    private int code;

    private String message;

    public CustomServerException(int code, String message){
        this.code = code;
        this.message = message;
    }

}
