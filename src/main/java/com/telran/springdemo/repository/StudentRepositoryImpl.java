package com.telran.springdemo.repository;

import com.telran.springdemo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    static List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        student.setId(students.size() + 1);
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public List<Student> findAllByName(String name) {
        return students
                .stream()
                .filter(x -> x.getName() != null && x.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public Student findById(Integer id) {
        return students.stream()
                .filter(x -> x != null && x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
