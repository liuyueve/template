package com.haizhi.template.bean.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Create by liu·yu
 * Date is 2020-09-01
 * Description is :
 */
@Data
@Entity
@Table(name = "garl")
public class GarlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer garl;

    private LocalDate start;

    private LocalDate end;

    private String name;

    private String content;

}
