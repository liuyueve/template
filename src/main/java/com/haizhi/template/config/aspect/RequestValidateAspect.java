package com.haizhi.template.config.aspect;

import com.haizhi.template.config.exception.CustomServerException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create by liuyu
 * Date is 2019-12-13
 * Description is : controller层方法参数校验
 */
@Slf4j
@Aspect
@Component
public class RequestValidateAspect {

    @Autowired
    private Validator validator;

    //类上面标注有RestController 并且方法上标注有Validated 才会被匹配到
    @Pointcut(value = "@within(org.springframework.web.bind.annotation.RestController) " +
            "&& @annotation(org.springframework.validation.annotation.Validated) ")
    public void point() {
    }

    @Around(value = "point()")
    //异常可以抛出，由全局异常处理中心处理
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object target = joinPoint.getTarget();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();

        Set<ConstraintViolation<Object>> violations = validateParameters(target, method, args);

        if (violations != null && violations.size() > 0) {
            throw new CustomServerException(-1,"参数校验未通过",joinErrors(violations));
        }
        return joinPoint.proceed();
    }

    /**
     * 对方法参数进行校验
     */
    private Set<ConstraintViolation<Object>> validateParameters(Object target, Method method, Object... args) {
        Class<?>[] groups = determineValidationGroups(method, target.getClass());
        Method methodToValidate = method;

        ExecutableValidator execVal = this.validator.forExecutables();
        Set<ConstraintViolation<Object>> result;
        try {
            result = execVal.validateParameters(
                    target, methodToValidate, args, groups);
        } catch (IllegalArgumentException ex) {
            methodToValidate = BridgeMethodResolver.findBridgedMethod(
                    ClassUtils.getMostSpecificMethod(method, target.getClass()));
            result = execVal.validateParameters(
                    target, methodToValidate, args, groups);
        }
        return result;
    }

    private Class<?>[] determineValidationGroups(Method method, Class target) {
        Validated validatedAnn = AnnotationUtils.findAnnotation(method, Validated.class);
        if (validatedAnn == null) {
            validatedAnn = AnnotationUtils.findAnnotation(target, Validated.class);
        }
        return (validatedAnn != null ? validatedAnn.value() : new Class<?>[0]);
    }

    private Map<String, String> joinErrors(Set<ConstraintViolation<Object>> violations) {
        return violations.stream()
                         .collect(Collectors.toMap(
                                 c -> c.getPropertyPath().toString(),
                                 c -> c.getInvalidValue() + "~" + c.getMessage()
                                 )
                         );
    }

}
