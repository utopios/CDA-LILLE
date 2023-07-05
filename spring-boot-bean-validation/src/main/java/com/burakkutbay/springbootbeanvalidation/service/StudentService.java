package com.burakkutbay.springbootbeanvalidation.service;

import com.burakkutbay.springbootbeanvalidation.model.Student;
import com.burakkutbay.springbootbeanvalidation.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void save(Student student){
        studentRepository.save(student);
    }
}
