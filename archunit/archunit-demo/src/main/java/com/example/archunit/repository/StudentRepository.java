package com.example.archunit.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.archunit.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
