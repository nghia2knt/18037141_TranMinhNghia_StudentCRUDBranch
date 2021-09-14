package com.example.spring_student_jpa.repository;

import com.example.spring_student_jpa.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Long> {

}
