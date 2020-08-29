package com.haizhi.template.bean.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Create by liu·yu
 * Date is 2020-08-01
 * Description is :
 */
@Data
@Entity
@Table(name = "vote_table")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDateTime time;

    private Boolean flag;

    private Integer integer;

}
