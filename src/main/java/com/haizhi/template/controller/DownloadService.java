package com.haizhi.template.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Create by liu·yu
 * Date is 2020-09-11
 * Description is :
 */
@Service
public class DownloadService {

    @Cacheable(value = "download")
    public String download(){
        System.out.println(" join in download ");
        return "success";
    }

}
