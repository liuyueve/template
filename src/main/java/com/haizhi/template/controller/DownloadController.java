package com.haizhi.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by liu·yu
 * Date is 2020-08-27
 * Description is :
 */
@RestController
public class DownloadController {

    @Autowired
    private DownloadService service;

    @GetMapping(value = "test",produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        return service.download();
    }

}
