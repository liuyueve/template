package com.haizhi.template.config.database;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

/**
 * Create by liu·yu
 * Date is 2020-08-06
 * Description is : jpa 相关配置文件
 */
@Configuration
@EntityScan("com.haizhi.template.bean.entity")
public class JpaConfig {

//    @Bean
//    public SessionFactory getSessionFactory(EntityManagerFactory entityManagerFactory){
//        return entityManagerFactory.unwrap(SessionFactory.class);
//    }

}
