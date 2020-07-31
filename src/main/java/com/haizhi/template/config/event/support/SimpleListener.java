package com.haizhi.template.config.event.support;

import com.haizhi.template.config.event.EventConfig;
import org.springframework.core.ParameterizedTypeReference;

/**
 * Create by liu·yu
 * Date is 2020-07-30
 * Description is : 极简事件监听器，用于单机服务解耦
 * {@link SimpleEventMulticaster}
 * {@link EventConfig}
 */
public interface SimpleListener<T> {

    /**
     * 该监听器可接收的消息类型
     */
    @SuppressWarnings("unchecked")
    default Class<T> getMatchType() {
        ParameterizedTypeReference<T> typeReference = new ParameterizedTypeReference<T>() {
        };
        return (Class<T>) typeReference.getType();
    }

    /**
     * 无状态接收
     */
    default void receive(T t) {
    }

    /**
     * 有状态接收
     */
    default void receiveByState(T t, int state) {
    }

}
