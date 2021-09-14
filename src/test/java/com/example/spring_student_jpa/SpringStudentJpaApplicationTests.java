package com.example.spring_student_jpa;

import com.example.spring_student_jpa.entity.Student;
import com.example.spring_student_jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringStudentJpaApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    private void insertTest(){
        Student student = Student.builder().email("nghia2knt@gmail.com").name("nghia 123").build();
        studentRepository.insertInJPQL(student.getId(),student.getEmail(),student.getName());
    }
    @Test
    private void updateTest(){
        Student student = Student.builder().email("nghiaTest@gmail.com").name("nghia 456").build();
        Long id = student.getId();
        studentRepository.insertInJPQL(student.getId(),student.getEmail(),student.getName());
        studentRepository.updateInJPQL("nghiaedit@gmail.com","nghia edit",id);

    }

    @Test
    private void getTest(){
        studentRepository.findInJPQL();
    }

    @Test
    private void deleteTest(){
        studentRepository.deleteInJPQL();
    }

}
