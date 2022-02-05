package com.example.archunit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;


import com.example.archunit.model.Student;
import com.example.archunit.repository.StudentRepository;

@Component
public class ServiceStudentImpl implements StudentService {

	private final StudentRepository studentRepository;
	//private final Logger log = LoggerFactory.getLogger(ServiceStudentImpl.class); //org.slf4j
	//private static Logger log = Logger.getLogger("StudentServiceImpl"); //java.util


	public ServiceStudentImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public Optional<Student> getStudentById(Long id) {
		//log.info("Find Student by id");
		System.out.println("Find Student by id");
		return studentRepository.findById(id);
	}


}
