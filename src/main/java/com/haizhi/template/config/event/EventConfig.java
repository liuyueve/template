package com.haizhi.template.config.event;

import com.haizhi.template.config.event.support.SimpleEventMulticaster;
import com.haizhi.template.config.event.support.SimpleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ErrorHandler;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by liu·yu
 * Date is 2020-07-30
 * Description is : 事件监听机制配置
 */
@Configuration
public class EventConfig {

    @Bean
    @Autowired(required = false)
    public SimpleEventMulticaster multicaster(List<SimpleListener> simpleListeners) {
        SimpleEventMulticaster eventMulticaster = new SimpleEventMulticaster(getExecutor(), getErrorHandler());

        if (simpleListeners != null && simpleListeners.size() > 0) {
            for (SimpleListener listener : simpleListeners) {
                eventMulticaster.addListener(listener);
            }
        }

        return eventMulticaster;
    }

    private Executor getExecutor() {
        return new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
    }

    private ErrorHandler getErrorHandler() {
        return new SimpleEventMulticaster.LogErrorHandler();
    }

}
