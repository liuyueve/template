package com.haizhi.template.config.servlet.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * Create by liuyu
 * Date is 2019-10-23
 * Description is : 空filter，摆这儿做示范
 */
@Slf4j
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

}
