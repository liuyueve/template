package com.haizhi.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

import java.io.File;

@SpringBootApplication
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
