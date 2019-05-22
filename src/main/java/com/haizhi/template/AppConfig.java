package com.haizhi.template;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

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

}
