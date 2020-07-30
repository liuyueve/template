package com.haizhi.template.config.event.support;

import com.haizhi.template.config.event.EventConfig;

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
    Class getMatchType();

    /**
     * 无状态接收
     * @param t
     * @throws Exception
     */
    default void receive(T t) throws Exception {
    }

    /**
     * 有状态接收
     * @param t
     * @param state
     */
    default void receiveByState(T t, int state) {
    }

}
