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

    private String msg;

    private T data;

    public ResultEntity(){}

    public static class Builder<T>{

        private ResultEntity<T> resultEntity;

        public Builder(){
            this.resultEntity = new ResultEntity<>();
        }

        public Builder<T> code(int code){
            this.resultEntity.code = code;
            return this;
        }

        public Builder<T> msg(String msg){
            this.resultEntity.msg = msg;
            return this;
        }

        public Builder<T> data(T data){
            this.resultEntity.data = data;
            return this;
        }

        public ResultEntity<T> build(){
            return this.resultEntity;
        }
    }

}
