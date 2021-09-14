package com.example.spring_student_jpa;

import com.example.spring_student_jpa.entity.Student;
import com.example.spring_student_jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringStudentJpaApplicationTests {


    @Autowired
    private StudentRepository studentRepository;


    // test các repo

    @Test
    private void insertStudent(){
        Student student=Student.builder().name("tran nghia").email("nghia2knt@gmail.com").build();
        studentRepository.save(student);
    }

    @Test
    private void printAllStudent(){
        List<Student> studentList = (List<Student>) studentRepository.findAll();
        System.out.println("List Student: " +studentList);
    }

    @Test
    private void getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        System.out.println("Student: " + student);
    }

    @Test
    private void deleteStudentById(Long id){
        studentRepository.deleteById(id);
        System.out.println("deleted!");
    }

}
