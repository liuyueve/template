package com.haizhi.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            SpringApplication application = new SpringApplication(Application.class);
            application.addListeners(new ApplicationPidFileWriter());
            application.run(args);
        } catch (Exception e) {
            System.out.println("fail key failllllllllll");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("start key successssssssss");
    }

}
