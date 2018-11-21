package com.telran.springdemo.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString


//POJO (Plain Old Java Object)
//Model
//DTO (data transfer object)
//Java Beans
public class Student {

    private Integer id;
    private String name;
    private String course;
}
