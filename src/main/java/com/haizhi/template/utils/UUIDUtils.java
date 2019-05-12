package com.haizhi.template.utils;

import java.util.UUID;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :生成uuid的工具类
 */
public class UUIDUtils {
    public static String randomUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
