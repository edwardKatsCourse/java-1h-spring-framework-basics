package com.telran.springdemo.service;


import com.telran.springdemo.exception.StudentNotFoundException;
import com.telran.springdemo.model.Student;
import com.telran.springdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByName(String name) {
        List<Student> studentsByName = studentRepository.findAllByName(name);
        if (studentsByName.isEmpty()) {
            throw new StudentNotFoundException("Student with such name " + name + " does not exist");
        }

        return studentsByName;
    }

    @Override
    public Student findById(Integer id) {
        Student student = studentRepository.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student with such id" + id + " does not exist");
        }

        return student;
    }
}
