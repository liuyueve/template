package com.haizhi.template;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Create by liuyu
 * Date is 2019-05-22
 * Description is : 全局配置类，可以在此处对配置文件添加相应的校验
 */
@Data
@Validated
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    @NotNull
    private Async async;

    @NotNull
    private Schedule schedule;

    @Data
    @Validated
    public static class Async {

        @NotNull
        private Integer corePoolSize;

        @NotNull
        private Integer maxPoolSize;

        @NotNull
        private Integer queueCapacity;

        @NotNull
        private Integer keepLiveSeconds;

    }

    @Data
    @Validated
    public static class Schedule {

        @NotNull
        private Integer corePoolSize;

    }

}
