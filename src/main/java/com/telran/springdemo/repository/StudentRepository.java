package com.telran.springdemo.repository;

import com.telran.springdemo.model.Student;

import java.util.List;

public interface StudentRepository {

    Student save(Student student);
    List<Student> findAll();
    List<Student> findAllByName(String name);
    Student findById(Integer id);
}
