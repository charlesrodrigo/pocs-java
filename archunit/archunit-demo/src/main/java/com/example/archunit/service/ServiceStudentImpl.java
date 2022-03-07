package com.example.archunit.service;

import com.example.archunit.model.Student;
import com.example.archunit.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceStudentImpl implements StudentService {

    private final StudentRepository studentRepository;

    public ServiceStudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        System.out.println("Find Student by id");
        return studentRepository.findById(id);
    }


}
