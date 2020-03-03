package com.haizhi.template.controller;

import com.haizhi.template.bean.ResultEntity;
import com.haizhi.template.bean.exception.CustomServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :controller层请求全局异常处理中心
 */
@Slf4j
@Validated
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * 处理rest请求参数校验失败的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity<Map<String, String>> paramValidate(MethodArgumentNotValidException e) {

        Map<String, String> collect = e.getBindingResult()
                                       .getFieldErrors()
                                       .stream()
                                       .collect(Collectors.toMap(FieldError::getField,
                                               f -> f.getRejectedValue() + "~" + f.getDefaultMessage()));

        return ResultEntity.<Map<String, String>>builder().code(-1)
                                                          .msg("参数校验未通过")
                                                          .data(collect)
                                                          .build();
    }

    @ExceptionHandler(CustomServerException.class)
    public ResultEntity<Object> serverException(CustomServerException e) {
        log.info("request error code [{}] msg[{}]", e.getCode(), e.getMessage());
        return ResultEntity.builder()
                           .code(e.getCode())
                           .msg(e.getMessage())
                           .data(e.getData())
                           .build();
    }

    /**
     * 处理其余未捕捉到的异常
     * （异常尽量定制处理，慎用Exception来捕捉）
     */
    @ExceptionHandler(Throwable.class)
    public ResultEntity<String> exception(Throwable e) {
        log.error("system exception!", e);
        return ResultEntity.<String>builder().code(-1)
                                             .msg("failed")
                                             .build();
    }

}
