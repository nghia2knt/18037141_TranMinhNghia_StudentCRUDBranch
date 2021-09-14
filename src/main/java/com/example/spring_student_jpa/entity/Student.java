package com.example.spring_student_jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
