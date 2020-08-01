package com.haizhi.template.bean.vo;

import lombok.Builder;
import lombok.Data;


/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is : rest接口返回通用包装类
 */
@Data
@Builder
public class ResultVo<T> {

    private int code;

    private String msg;

    private T data;

    public static <V> ResultVo<V> ok(V v) {
        return ResultVo.<V>builder().code(0).msg("success").data(v).build();
    }

    public static <V> ResultVo<V> error(V v) {
        return ResultVo.<V>builder().code(-1).msg("failed").data(v).build();
    }

}
