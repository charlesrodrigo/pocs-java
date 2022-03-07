package com.example.archunit.controller;

import com.example.archunit.model.Student;
import com.example.archunit.repository.StudentRepository;
import com.example.archunit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }


}
