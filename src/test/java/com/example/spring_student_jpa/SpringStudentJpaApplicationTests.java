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
    public void insertStudent(){
        Student student=Student.builder().name("tran nghia").email("nghia2knt@gmail.com").build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = (List<Student>) studentRepository.findAll();
        System.out.println("List Student: " +studentList);
    }

    @Test
    public void getStudentById(){
        Long id = 12L;
        Optional<Student> student = studentRepository.findById(id);
        System.out.println("Student: " + student);
    }

    @Test
    public void deleteStudentById(){
        Long id = 12L;
        studentRepository.deleteById(id);
        System.out.println("deleted id  "+id );
    }

}
