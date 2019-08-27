package com.haizhi.template.config.schedule;

import com.haizhi.template.AppConfig;
import com.haizhi.template.utils.ThreadMdcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :定制定时任务线程池线程数量
 */
@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    @Autowired
    private AppConfig config;

    /**
     * 根据自己定时任务的数量，制定对于的线程池数量
     * 避免每个定时任务之间相互干扰
     * @return
     */
    @Bean
    public TaskScheduler schedule(){
        return new ConcurrentTaskScheduler(getTraceIdSchedule());
    }

    private ScheduledThreadPoolExecutor getTraceIdSchedule(){
        return new ScheduledThreadPoolExecutor(config.getSchedule().getCorePoolSize()) {
            @Override
            public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
                return super.schedule(ThreadMdcUtils.wrapSchedule(command), delay, unit);
            }

            @Override
            public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
                return super.scheduleAtFixedRate(ThreadMdcUtils.wrapSchedule(command), initialDelay, period, unit);
            }

            @Override
            public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
                return super.scheduleWithFixedDelay(ThreadMdcUtils.wrapSchedule(command), initialDelay, delay, unit);
            }
        };
    }

}

