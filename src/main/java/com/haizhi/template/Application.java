package com.haizhi.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.File;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.haizhi.template.mapper")
public class Application {

    public static void main(String[] args) {
        try {
            SpringApplication application = new SpringApplication(Application.class);
            application.addListeners(new ApplicationPidFileWriter(getPidFile(args)));
            application.run(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static File getPidFile(String[] args) {
        String name = "application";
        for (String s : args) {
            if (s.contains("pid")) {
                name = name +"_"+ s.substring(s.indexOf("=")+1);
                break;
            }
        }
        return new File(name+".pid");
    }

}
