package com.haizhi.template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :添加全局配置的拦截器进入框架
 */
@Component
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired(required = false)
    private List<HandlerInterceptor> interceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (interceptors != null && interceptors.size() > 0) {
            for (HandlerInterceptor interceptor : interceptors) {
                registry.addInterceptor(interceptor);
            }
        }
    }
}
