package com.pinxue.qianwei.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "resource_path")
public class ResourcePath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id
    private Long id;

    //起始时间
    private Long startTime;

    //终止时间
    private Long endTime;

    //资源路径
    private String path;


}
