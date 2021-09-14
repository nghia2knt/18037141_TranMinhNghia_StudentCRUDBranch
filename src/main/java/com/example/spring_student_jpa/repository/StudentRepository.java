package com.example.spring_student_jpa.repository;

import com.example.spring_student_jpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Long> {


    @Modifying
    @Query(
            value = "INSERT INTO tbl_student VALUES (:id,:email,:name)",
            nativeQuery = true)
    void insertInNative(@Param("id") Long id, @Param("email") String email, @Param("name") String name);

    @Modifying
    @Query(value = "update tbl_student s set s.email = ?, s.name = ?  where s.id = ?",
            nativeQuery = true)
    int updateInNative(String email, String name, Long id);


    @Query(
            value = "select * from tbl_student",
            nativeQuery = true
    )
    List<Student> findAllInNative();

    @Query(
            value = "delete * from tbl_student",
            nativeQuery = true
    )
    void deleteAllInNative();
}
