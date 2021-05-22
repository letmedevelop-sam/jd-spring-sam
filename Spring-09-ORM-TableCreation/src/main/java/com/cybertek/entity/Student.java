package com.cybertek.entity;

import com.cybertek.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //as we use camelCase  structure in table we will see _ between words
    @Column(name = "studentFirstName")
    private String firstName;  //first_name
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentFirstEmail")
    private String email;

    @Transient
    private String city;

    @Temporal(TemporalType.DATE)
 //   @Column(columnDefinition = "DATE")          //Java 8
    private Date birthDate;

    @Temporal(TemporalType.TIME)
//    @Column(columnDefinition = "TIME")          //Java 8
    private Date birthTime;

    @Temporal(TemporalType.TIMESTAMP)
//    @Column(columnDefinition = "TIMESTAMP")         //Java 8
    private Date getBirthDateTime;

    @Enumerated (EnumType.STRING)  //it comes as  @Enumerated (EnumType.ORDINAL) //change it to STRING
    private Gender gender;  //normally it automatically comes as integer to DB as 0 or 1



}
