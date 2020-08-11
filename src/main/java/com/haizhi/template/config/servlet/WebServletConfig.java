package com.haizhi.template.config.servlet;

import com.haizhi.template.config.servlet.filter.FirstFilter;
import com.haizhi.template.config.servlet.filter.SecondFilter;
import com.haizhi.template.config.servlet.listener.EmptyListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.EventListener;

/**
 * Create by liuyu
 * Date is 2020-03-03
 * Description is : web filter and listener config
 */
//@Configuration
public class WebServletConfig {

    @Bean
    public FilterRegistrationBean firstFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new FirstFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        bean.setName("first");
        return bean;
    }

    @Bean
    public FilterRegistrationBean secondFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new SecondFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(2);
        bean.setName("second");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean listener(){
        ServletListenerRegistrationBean<EventListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new EmptyListener());
        return bean;
    }

}
