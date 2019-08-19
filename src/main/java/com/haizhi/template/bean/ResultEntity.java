package com.haizhi.template.bean;

import lombok.Data;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is : rest接口返回通用包装类
 */
@Data
public class ResultEntity<T> {

    private int code;

    private String message;

    private T body;

    public ResultEntity(){}

    public ResultEntity(T t){
        this.body = t;
        this.code = 0;
        this.message = "success!";
    }

}