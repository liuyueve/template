package com.haizhi.template.config.interceptor;

import com.haizhi.template.config.interceptor.handle.TraceIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :添加全局配置的拦截器进入框架
 */
@Component
public class GlobalWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private TraceIdInterceptor traceIdInterceptor;

    @Override
    /*
      traceId 拦截器需要在最开始执行
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceIdInterceptor).order(0);
    }

}
