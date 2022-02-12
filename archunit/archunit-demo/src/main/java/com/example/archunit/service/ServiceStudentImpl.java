package com.example.archunit.service;

import com.example.archunit.model.Student;
import com.example.archunit.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ServiceStudentImpl implements StudentService {

    private final StudentRepository studentRepository;
    //private final Logger log = LoggerFactory.getLogger(ServiceStudentImpl.class); //org.slf4j
    //private static Logger log = Logger.getLogger("StudentServiceImpl"); //java.util


    public ServiceStudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        //log.info("Find Student by id");
        System.out.println("Find Student by id");
        return studentRepository.findById(id);
    }


}
