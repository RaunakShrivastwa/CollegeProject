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
@Table(name = "Employee")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 60)
    private String password;

    @Column(nullable = false,unique = true,length = 45)
    private String email;

    @Column(nullable = false,length = 20)
    private String firstName;

    @Column(nullable = false,length = 20)
    private String lastName;

    private String role;

    @Column(nullable = false,length = 200)
    String about;

    @Column(nullable = false,length = 200)
    String age;

    @Column(nullable = false,length = 200)
    String sem;

    @Column(nullable = false,length = 200)
    String status;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;


}
