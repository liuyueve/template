package com.haizhi.template.bean.bo;

import lombok.Data;

import java.util.List;

/**
 * Create by liu·yu
 * Date is 2020-08-14
 * Description is :
 */
@Data
public class PojoBean {

    private String packageName;

    private List<String> imports;

    private boolean useLombok;

    private String beanName;

    private List<TypeMap> typeMap;


    @Data
    public static class TypeMap{
        private String type;
        private String name;
    }

}
