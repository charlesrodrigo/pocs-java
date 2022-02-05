package com.example.archunit.controller;

import java.util.List;

import com.example.archunit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.archunit.model.Student;
import com.example.archunit.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		//new ResponseStatusException(HttpStatus.NOT_FOUND)
		return studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}


}
