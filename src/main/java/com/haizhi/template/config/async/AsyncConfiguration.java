package com.haizhi.template.config.async;

import com.haizhi.template.utils.ThreadMdcUtils;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :使用自定义异步线程池，根据项目需求自己定义线程池各参数
 */
@EnableAsync
@Configuration
public class AsyncConfiguration {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //设置核心线程数量
        executor.setCorePoolSize(4);
        //设置最大线程数量
        executor.setMaxPoolSize(8);
        //设置队列最大长度
        executor.setQueueCapacity(2000);
        //设置线程空闲时间
        executor.setKeepAliveSeconds(10);
        //设置线程前缀
        executor.setThreadNamePrefix("async-");
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //设置线程装饰器
        executor.setTaskDecorator(runnable -> ThreadMdcUtils.wrapAsync(runnable, MDC.getCopyOfContextMap()));
        return executor;
    }
}
