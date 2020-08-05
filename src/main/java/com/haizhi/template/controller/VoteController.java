package com.haizhi.template.controller;

import com.haizhi.template.bean.entity.Vote;
import com.haizhi.template.mapper.VoteRepository;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

/**
 * Create by liu·yu
 * Date is 2020-08-01
 * Description is :
 */
@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    @Transactional
    public void test() {
//        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//
////        voteRepository.save(vote);
//        System.out.println(entityManagerFactory instanceof SessionFactory);
//        System.out.println(entityManagerFactory.getClass());
//        Optional<Vote> byId = voteRepository.findById(1);
//        Vote one = voteRepository.getOne(1);
//        System.out.println(byId.get());
//        System.out.println("***************************");
//        System.out.println("***************************");
//        System.out.println("***************************");
//        System.out.println("***************************");
//        System.out.println("***************************");
//        System.out.println("***************************");
    }


}
