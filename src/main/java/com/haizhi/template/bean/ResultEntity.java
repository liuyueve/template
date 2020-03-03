package com.haizhi.template.bean;

import lombok.Builder;
import lombok.Data;


/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is : rest接口返回通用包装类
 */
@Data
@Builder
public class ResultEntity<T> {

    private int code;

    private String msg;

    private T data;

    public static <V> ResultEntity<V> ok(V v) {
        return ResultEntity.<V>builder().code(0).msg("success").data(v).build();
    }

    public static <V> ResultEntity<V> error(V v) {
        return ResultEntity.<V>builder().code(-1).msg("failed").data(v).build();
    }

}
