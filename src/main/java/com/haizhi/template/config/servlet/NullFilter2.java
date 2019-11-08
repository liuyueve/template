package com.haizhi.template.config.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Create by liuyu
 * Date is 2019-10-23
 * Description is : 空filter，摆这儿做示范
 */
@Slf4j
@WebFilter(urlPatterns = "/hello/*")
public class NullFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("this is filter 2");
        HttpServletRequest request1 = (HttpServletRequest) request;
        request1.getSession(true);
        chain.doFilter(request, response);
    }

}
