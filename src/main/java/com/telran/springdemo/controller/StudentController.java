package com.telran.springdemo.controller;

import com.telran.springdemo.model.Student;
import com.telran.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//      http://locahost:8080/students


/**
 * Spring beans:
 * 1. Created by Spring
 * 2. Are managed by Spring (keep reference on such class)
 * 3. Are created as singletons (by default)
 * 4. Spring manages multi-threaded access to such classes
 *
 * Spring BEAN TYPES:
 * - @Controller     -> receives requests and returns responses
 *
 * - @RestController ->
 * same as @Controller,
 * but incoming requests and outgoing responses
 * are converted to JSON automatically
 *
 * - @Repository
 * Classes, that are responsible for database operations for an objects (i.e. Student)
 * Operations: save, update, delete, find by (name, id, name and course, course and id .... )
 *
 * MySQL....Exception
 * PostgresSQL
 *
 * - @Configuration
 * Created before others
 * May create our own beans is such classes
 * We configure Spring application inside such classes
 *
 * - @Service
 * Plain bean
 * Participate in Spring architecture:
 * controller -> service -> repository
 *
 * - @Component
 *  Plain bean
 */

@RequestMapping("/students")
@RestController //bean name "studentController"
//    bean name      bean instance
//Map<String,           Object>
public class StudentController {

    //DI (dependency injection)

    @Autowired //@Автосвязывание
    //studentService

    private StudentService studentService;



    @GetMapping("/all")
    public List<Student> getAll() {
        return studentService.findAll();
    }


//    @GetMapping
//    public String index(ModelAndView modelAndView) {
//        modelAndView.addObject()
//
//        return "index.jsp";
//    }


    // http://localhost:8080/students/save
    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/id/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }

//
//    @GetMapping("/hello")
//    public void hello() {
//    }


    @GetMapping("/name/{name}") //   /hello
    public List<Student> findAllByName(@PathVariable("name") String name) {
        return studentService.findAllByName(name);
    }

}
