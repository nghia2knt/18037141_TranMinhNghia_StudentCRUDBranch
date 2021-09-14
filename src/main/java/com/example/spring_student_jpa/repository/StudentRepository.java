package com.example.spring_student_jpa.repository;

import com.example.spring_student_jpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Long> {

    // insert sử dụng cả native và Modifying
    @Modifying
    @Query(
            value = "INSERT INTO tbl_student VALUES (:id,:email,:name)",
            nativeQuery = true)
    void insertInJPQL(@Param("id") Long id, @Param("email") String email, @Param("name") String name);


    @Modifying
    @Query("update Student s set s.email = :email, s.name = :name where s.id = :id")
    void updateInJPQL(@Param("email") String email,
                                   @Param("name") String name,
                                   @Param("id") Long id);


    @Query("SELECT s FROM Student s")
    List<Student> findInJPQL();

    @Query("Delete from Student")
    void deleteInJPQL();
}
