package com.haizhi.template.controller;

import com.haizhi.template.bean.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by liuyu
 * Date is 2019-05-12
 * Description is :controller层请求全局异常处理中心
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * 处理rest请求参数校验失败的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> paramValidate(MethodArgumentNotValidException e){
        ResponseEntity<List<String>> entity = new ResponseEntity<>();
        entity.setCode(-1);
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        if(allErrors.size()<=0){
            entity.setMessage("system exception!");
        }
        List<String> collect = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
        entity.setMessage(Strings.join(collect,';'));
        entity.setBody(collect);
        return entity;
    }

    /**
     * 处理其余未捕捉到的异常
     * （异常尽量定制处理，慎用Exception来捕捉）
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> exception(Exception e){
        log.error("system exception!",e);
        ResponseEntity<Exception> entity = new ResponseEntity<>();
        entity.setCode(-1);
        entity.setMessage("system exception!");
        entity.setBody(e);
        return entity;
    }

}
