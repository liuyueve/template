package com.haizhi.template.config.mybatis.resultHandlers;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Create by liuyu
 * Date is 2019-11-21
 * Description is : mybatis 自定义结果集,将结果集转换为map
 */
public class MapHandler<K, V, T> implements ResultHandler<T> {

    private Map<K, V> result = new HashMap<>();

    private Function<T,K> key;

    private Function<T,V> value;

    public MapHandler(Function<T,K> key,Function<T,V> value){
        this.key = key;
        this.value = value;
    }

    @Override
    public void handleResult(ResultContext<? extends T> resultContext) {
        T t = resultContext.getResultObject();
        result.put(key.apply(t),value.apply(t));
    }

    public Map<K,V> getResult(){
        return this.result;
    }
}
