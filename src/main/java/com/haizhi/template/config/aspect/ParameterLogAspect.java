package com.haizhi.template.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by liuyu
 * Date is 2019-10-23
 * Description is : 使用aop记录每个请求的参数和返回值
 */
@Slf4j
@Aspect
@Component
public class ParameterLogAspect {

    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController)")
    public void pointCut() {
    }

    @Around("pointCut()")
    //异常可以抛出，由全局异常处理中心处理
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        if (log.isInfoEnabled()) {
            log.info("request parameter [{}]", handleRequestParameter(point));
        }
        Object proceed = point.proceed();
        if (log.isInfoEnabled()) {
            log.info("response [{}]", proceed);
            HttpServletRequest request = getRequest();
            long timeCost = System.currentTimeMillis() - start;
            if (request != null) {
                log.info("method [{}] remote ip [{}] port [{}] time cost [{}ms]",
                        request.getMethod(), request.getRemoteAddr(), request.getRemotePort(), timeCost);
            }
            HttpServletResponse response = getResponse();
            if (response != null) {
                response.addHeader("timeCost", timeCost + "ms");
            }
        }
        return proceed;
    }

    private Map<String, Object> handleRequestParameter(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Parameter[] parameters = signature.getMethod().getParameters();
        Object[] args = point.getArgs();
        if (args != null && args.length > 0) {
            Map<String, Object> parameter = new HashMap<>();
            for (int i = 0; i < args.length; i++) {
                if (isLogParameter(parameters[i])) {
                    parameter.put(parameters[i].getName(), args[i]);
                }
            }
            return parameter;
        }
        return null;
    }

    private boolean isLogParameter(Parameter parameter) {
        Annotation[] annotations = parameter.getAnnotations();
        if (annotations != null && annotations.length > 0)
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> type = annotation.annotationType();
                if (type.isAssignableFrom(RequestParam.class)
                        || type.isAssignableFrom(RequestBody.class)
                        || type.isAssignableFrom(RequestHeader.class)
                        || type.isAssignableFrom(PathVariable.class)) {
                    return true;
                }
            }
        return false;
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getRequest();
        }
        return null;
    }

    private HttpServletResponse getResponse() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return attributes.getResponse();
        }
        return null;
    }

}
