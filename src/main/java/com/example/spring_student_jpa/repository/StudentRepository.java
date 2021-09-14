package com.example.spring_student_jpa.repository;

import com.example.spring_student_jpa.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface StudentRepository  extends CrudRepository<Student,Long> {

    @PersistenceContext
    public EntityManager entityManager = null;

    @Transactional
    public default void insertWithQuery(Student student) {
        entityManager.createNativeQuery("INSERT INTO tbl_student (id, email, name) VALUES (?,?,?)")
                .setParameter(1, student.getId())
                .setParameter(2, student.getEmail())
                .setParameter(3, student.getName())
                .executeUpdate();
    }
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
