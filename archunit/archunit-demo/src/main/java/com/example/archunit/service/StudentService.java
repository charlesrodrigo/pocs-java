package com.example.archunit.service;

import com.example.archunit.model.Student;

import java.util.Optional;

public interface StudentService {

    Optional<Student> findById(Long id);

    Student save(Student student);

}
