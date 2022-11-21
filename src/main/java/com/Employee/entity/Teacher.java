package com.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false,unique = true,length = 45)
    String teacherEmail;

    @Column(nullable = false,length = 300)
    String teacherPassword;

    @Column(nullable = false,length = 20)
    String teacherName;

    @Column(nullable = false,length = 20)
    String teacherAge;

    @Column(nullable = false,length = 20)
    String teacherSubject;

    @Column(nullable = false,length = 20)
    String teacheRole;

    @Column(nullable = false,length = 20)
    String teacherQualification;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String teacherImage;

}
