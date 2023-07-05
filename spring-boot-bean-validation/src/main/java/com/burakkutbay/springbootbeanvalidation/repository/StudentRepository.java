package com.burakkutbay.springbootbeanvalidation.repository;

import com.burakkutbay.springbootbeanvalidation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface   StudentRepository extends JpaRepository<Student,Long> {
}
