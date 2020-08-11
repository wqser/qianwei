package com.pinxue.qianwei.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id
    private Long id;

    //名字
    private String name;

    //手机号码
    private String mb;

    //时间
    private String time;

}
