package com.haizhi.template.config.event.support;

import com.haizhi.template.config.event.EventConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import org.springframework.util.ErrorHandler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Create by liu·yu
 * Date is 2020-07-30
 * Description is : 极简的事件传播组件,应用于单个服务间各模块的解耦
 * {@link SimpleListener}
 * {@link EventConfig}
 */
@Slf4j
public class SimpleEventMulticaster {

    /**
     * 异步执行线程池，不可为空
     */
    @NonNull
    private Executor executor;

    /**
     * 异常处理器，处理传播事件过程的异常，事件处理异常不应影响主程序
     */
    @NonNull
    private ErrorHandler errorHandler;

    /**
     * 事件通过处理类型来区分
     */
    private MultiValueMap<Class, SimpleListener> listenerMap = new LinkedMultiValueMap<>();

    public SimpleEventMulticaster(Executor executor, ErrorHandler errorHandler) {
        Assert.notNull(executor, "executor in SimpleEventMulticaster can not be null!");
        Assert.notNull(errorHandler, "errorHandler in SimpleEventMulticaster can not be null!");
        this.executor = executor;
        this.errorHandler = errorHandler;
    }

    /**
     * 添加listener
     * @param listener 需要传播的事件
     */
    public void addListener(SimpleListener listener) {
        Class matchType = listener.getMatchType();
        listenerMap.add(matchType, listener);
    }

    /**
     * 同步，无状态传播
     * @param object 需要传播的事件
     */
    public void syncMulticast(Object object) {
        List<SimpleListener> listeners = listenerMap.get(object.getClass());
        if (listeners == null || listeners.size() == 0) {
            return;
        }
        for (SimpleListener listener : listeners) {
            invokeListener(listener, object);
        }
    }

    /**
     * 同步，有状态传播
     * @param object 需要传播的消息
     * @param state 状态码
     */
    public void syncMulticastWithState(Object object, int state) {
        List<SimpleListener> listeners = listenerMap.get(object.getClass());
        if (listeners == null || listeners.size() == 0) {
            return;
        }
        for (SimpleListener listener : listeners) {
            invokeListenerWithState(listener, object, state);
        }
    }

    /**
     * 异步，无状态传播
     * @param object 需要传播的事件
     */
    public void asyncMulticast(Object object) {
        List<SimpleListener> listeners = listenerMap.get(object.getClass());
        if (listeners == null || listeners.size() == 0) {
            return;
        }
        for (SimpleListener listener : listeners) {
            getExecutor().execute(() -> invokeListener(listener, object));
        }
    }

    /**
     * 异步，有状态传播
     * @param object 需要传播的事件
     * @param state 状态码
     */
    public void asyncMulticastWithState(Object object, int state) {
        List<SimpleListener> listeners = listenerMap.get(object.getClass());
        if (listeners == null || listeners.size() == 0) {
            return;
        }
        for (SimpleListener listener : listeners) {
            getExecutor().execute(() -> invokeListenerWithState(listener, object, state));
        }
    }

    @SuppressWarnings("unchecked")
    private void invokeListener(SimpleListener listener, Object obj) {
        try {
            listener.receive(obj);
        } catch (Throwable throwable) {
            getErrorHandler().handleError(throwable);
        }
    }

    @SuppressWarnings("unchecked")
    private void invokeListenerWithState(SimpleListener listener, Object obj, int state) {
        try {
            listener.receiveByState(obj, state);
        } catch (Throwable throwable) {
            getErrorHandler().handleError(throwable);
        }
    }

    @NonNull
    public Executor getExecutor() {
        return executor;
    }

    @NonNull
    public ErrorHandler getErrorHandler() {
        return errorHandler;
    }

    public static class LogErrorHandler implements ErrorHandler {

        @Override
        public void handleError(Throwable t) {
            log.error("Error calling SimpleEventMulticaster", t);
        }

    }
}
