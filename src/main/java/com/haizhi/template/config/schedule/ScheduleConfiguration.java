package com.haizhi.template.config.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :定制定时任务线程池线程数量
 */
@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    /**
     * 根据自己定时任务的数量，制定对于的线程池数量
     * 避免每个定时任务之间相互干扰
     * @return
     */
    @Bean
    public TaskScheduler schedule(){
        return new ConcurrentTaskScheduler(new ScheduledThreadPoolExecutor(2));
    }

}

