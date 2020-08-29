package com.haizhi.template.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Create by liu·yu
 * Date is 2020-08-27
 * Description is :
 */
@RestController
public class DownloadController {

//    @GetMapping("download")
//    public void download(HttpServletResponse response) throws IOException {
//        File file = new File("/Users/liuyu/Desktop/刘宇周报.xlsx");
//        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("刘宇周报.xlsx", "UTF-8"));
//        InputStream in = new FileInputStream(file);
//        IOUtils.copy(in, response.getOutputStream());
//        in.close();
//    }

}
