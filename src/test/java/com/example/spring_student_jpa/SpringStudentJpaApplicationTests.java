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
       Student student=Student.builder().name("tran nghia").email("nghia2knt@gmail.com").build();
       studentRepository.insertWithQuery(student);
   }

   @Test
    private void getTest(){
       studentRepository.findAllInNative();
   }

   @Test
    private void deleteTest(){
       studentRepository.deleteAllInNative();
   }
}
