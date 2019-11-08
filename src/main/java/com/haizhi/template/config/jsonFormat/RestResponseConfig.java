package com.haizhi.template.config.jsonFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

/**
 * Create by liuyu
 * Date is 2019-08-27
 * Description is : rest 接口返回json格式全局配置
 */
@Configuration
public class RestResponseConfig {

    @Autowired(required = false)
    private List<BeanSerializerModifier> modifierList;

    @Bean
    public HttpMessageConverters message() {
        return new HttpMessageConverters(getHttpMessageConverter());
    }

    private HttpMessageConverter getHttpMessageConverter() {
        if (modifierList != null && modifierList.size() > 0) {
            return new MappingJackson2HttpMessageConverter(wrapper());
        }
        return new MappingJackson2HttpMessageConverter(getObjectMapper());
    }

    private ObjectMapper wrapper() {
        ObjectMapper objectMapper = getObjectMapper();
        objectMapper.setSerializerFactory(getSerializerFactory(objectMapper));
        return objectMapper;
    }

    private SerializerFactory getSerializerFactory(ObjectMapper objectMapper) {
        SerializerFactory factory = objectMapper.getSerializerFactory();
        for (BeanSerializerModifier modifier : modifierList) {
            factory = factory.withSerializerModifier(modifier);
        }
        return factory;
    }

    private ObjectMapper getObjectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                                          .modules(getModule())
                                          .featuresToEnable(enableFeature())
                                          .featuresToDisable(disableFeature())
                                          .serializationInclusion(JsonInclude.Include.NON_EMPTY)
                                          .timeZone(TimeZone.getTimeZone(ZoneId.of("GMT+8")))
                                          .build();
    }

    private Module getModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        return module;
    }

    private Object[] enableFeature() {
        return new Object[]{
                SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS
//                , JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS
        };
    }

    private Object[] disableFeature() {
        return new Object[]{SerializationFeature.WRITE_DATES_AS_TIMESTAMPS};
    }
}
