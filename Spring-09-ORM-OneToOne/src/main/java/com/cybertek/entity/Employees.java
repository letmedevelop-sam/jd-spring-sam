package com.cybertek.entity;

import com.cybertek.enums.Gender;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "employeeTable")
public class Employees {
    @Id
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;

    @Temporal(TemporalType.DATE)
    private Date hireDate;
//    private String department;        //This column will come from JOIN

    @Enumerated (EnumType.STRING)
    private Gender gender;
    private int salary;
//    private int regionId;         //This column will come from JOIN



}
