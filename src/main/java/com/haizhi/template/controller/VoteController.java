package com.haizhi.template.controller;

import com.haizhi.template.bean.entity.GarlEntity;
import com.haizhi.template.bean.entity.Vote;
import com.haizhi.template.mapper.GarlRepository;
import com.haizhi.template.mapper.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private GarlRepository garlRepository;

    @PostConstruct
    public void run() {
//        Pageable pageRequest = PageRequest.of(0, 10);
        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.of(2021, 1, 1);
//        while (true) {
//            System.out.println(pageRequest.getPageNumber());
//            System.out.println(pageRequest.getPageSize());
//            Page<GarlEntity> page = garlRepository.findAllByStartBetween(start, end, pageRequest);
//            for (GarlEntity entity : page) {
//                System.out.println(entity);
//            }
//            if (!page.hasNext()) {
//                break;
//            }
//            pageRequest = page.nextPageable();
//        }
        List<Integer> garl = garlRepository.findAllByStartBetween(start, end);
        System.out.println(garl);
    }

//    @PostMapping("save")
//    public String saveVote(@RequestBody Vote vote) {
//        System.out.println(vote);
//        Vote save = voteRepository.save(vote);
//        System.out.println(save);
//        return "success";
//    }
//
//    @GetMapping("query")
//    public void query() {
//        Date start = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
//        Date end = new Date();
//        List<Vote> votes = voteRepository.queryAllByCreateTimeBetween(start, end);
//        System.out.println(votes);
//    }
//
//    @GetMapping("test")
//    public void test(@RequestParam("files") List<MultipartFile> files){
//        for (MultipartFile file : files) {
//            System.out.println(file.getName());
//        }
//    }

}
