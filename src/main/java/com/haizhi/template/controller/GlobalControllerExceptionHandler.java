package com.haizhi.template.controller;

import com.haizhi.template.bean.ResultEntity;
import com.haizhi.template.bean.exception.CustomServerException;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
    public ResultEntity<List<String>> paramValidate(MethodArgumentNotValidException e) {
        ResultEntity<List<String>> entity = new ResultEntity<>();
        entity.setCode(-1);
        List<String> collect = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
        joinValidMessage(entity, collect);
        return entity;
    }

    /**
     * 处理除了controller入口外，其余的逻辑@Valid校验异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultEntity<List<String>> valid(ConstraintViolationException e) {
        ResultEntity<List<String>> entity = new ResultEntity<>();
        entity.setCode(-1);
        List<String> collect = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        joinValidMessage(entity, collect);
        return entity;
    }

    private void joinValidMessage(ResultEntity<List<String>> entity, List<String> list) {
        if (list.size() <= 0) {
            entity.setMsg("system exception!");
        } else {
            entity.setMsg(Strings.join(list, ';'));
            entity.setData(list);
        }
    }

    @ExceptionHandler(CustomServerException.class)
    public ResultEntity<String> serverException(CustomServerException e) {
        log.info("request error code [{}] msg[{}]",e.getCode(),e.getMessage());
        return new ResultEntity.Builder<String>().code(e.getCode())
                                                 .msg(e.getMessage())
                                                 .build();
    }

    /**
     * 处理其余未捕捉到的异常
     * （异常尽量定制处理，慎用Exception来捕捉）
     */
    @ExceptionHandler(Throwable.class)
    public ResultEntity<Exception> exception(Throwable e) {
        log.error("system exception!", e);
        ResultEntity<Exception> entity = new ResultEntity<>();
        entity.setCode(-1);
        entity.setMsg("system exception!");
        return entity;
    }

}
