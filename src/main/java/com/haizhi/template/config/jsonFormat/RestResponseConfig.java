package com.haizhi.template.config.jsonFormat;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.haizhi.template.config.jsonFormat.serializer.LocalDateSerializer;
import com.haizhi.template.config.jsonFormat.serializer.LocalDateTimeSerializer;
import com.haizhi.template.config.jsonFormat.serializer.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Create by liuyu
 * Date is 2019-08-27
 * Description is : rest 接口返回json格式全局配置
 */
@Configuration
public class RestResponseConfig {

    @Bean
    public HttpMessageConverters message() {
        return new HttpMessageConverters(getHttpMessageConverter());
    }

    private HttpMessageConverter getHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJson = new FastJsonHttpMessageConverter();
        fastJson.setFastJsonConfig(getFastJsonConfig());
        return fastJson;
    }

    private FastJsonConfig getFastJsonConfig() {
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(getSerializerFeature());
        config.setSerializeConfig(getSerializeConfig());
        return config;
    }

    private SerializerFeature[] getSerializerFeature() {
        return new SerializerFeature[]{SerializerFeature.PrettyFormat,SerializerFeature.WriteNullStringAsEmpty};
    }

    private SerializeConfig getSerializeConfig() {
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.put(BigDecimal.class, ToStringSerializer.instance);
        serializeConfig.put(LocalDateTime.class, LocalDateTimeSerializer.instance);
        serializeConfig.put(LocalDate.class, LocalDateSerializer.instance);
        serializeConfig.put(LocalTime.class, LocalTimeSerializer.instance);
        return serializeConfig;
    }

}
