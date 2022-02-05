package com.example.archunit.service;

import java.util.List;
import java.util.Optional;

import com.example.archunit.model.Student;

public interface StudentService {
	
	Optional<Student> getStudentById(Long id);
	Student saveStudent(Student student);

}
