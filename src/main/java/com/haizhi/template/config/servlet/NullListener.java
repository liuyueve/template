package com.haizhi.template.config.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Create by liuyu
 * Date is 2019-10-23
 * Description is : 空listener，摆这儿做示范
 */
@Slf4j
@WebListener
public class NullListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session create");
    }
}
