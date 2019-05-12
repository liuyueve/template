package com.haizhi.template.config.traceId;

import com.haizhi.template.config.Constant;
import com.haizhi.template.utils.UUIDUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :在请求进入springboot服务时，添加日志的traceId。
 *                 方便追踪日志的请求
 */
@Component
public class TraceIdInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = UUIDUtils.randomUUID();
        MDC.put(Constant.TRACEID, traceId);
        response.addHeader(Constant.TRACEID,traceId);
        return true;
    }
}
