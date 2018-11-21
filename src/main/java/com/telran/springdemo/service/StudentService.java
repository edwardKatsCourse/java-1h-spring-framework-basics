package com.telran.springdemo.service;

import com.telran.springdemo.model.Student;

import java.util.List;



public interface StudentService {

    Student save(Student student);
    List<Student> findAll();
    List<Student> findAllByName(String name);
    Student findById(Integer id);
}
