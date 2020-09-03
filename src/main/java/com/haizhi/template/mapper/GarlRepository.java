package com.haizhi.template.mapper;

import com.haizhi.template.bean.entity.GarlEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Create by liu·yu
 * Date is 2020-09-01
 * Description is :
 */
public interface GarlRepository extends JpaRepository<GarlEntity, Integer> {

    @Query(nativeQuery = true,
            value = "select g2.* from garl g1 left join (select * from garl) g2 using (garl) where g1.start between ?1 and ?2 ",
            countQuery = "select count(*) from garl where start between ?1 and ?2")
    Page<GarlEntity> findAllByStartBetween(LocalDate start, LocalDate end, Pageable pageable);

    @Query(value = "select g.garl from GarlEntity g where g.start between ?1 and ?2")
    List<Integer> findAllByStartBetween(LocalDate start, LocalDate end);

}
