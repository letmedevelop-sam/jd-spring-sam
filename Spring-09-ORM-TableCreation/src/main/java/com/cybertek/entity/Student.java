package com.cybertek.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //as we use camelCase  structure in table we will see _ between words
    private String firstName;  //first_name
    private String lastName;
    private String email;



}
