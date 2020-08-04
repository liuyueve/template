package com.haizhi.template.mapper;

import com.haizhi.template.bean.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by liu·yu
 * Date is 2020-08-01
 * Description is :
 */
public interface VoteRepository extends JpaRepository<Vote,Integer> {
}
