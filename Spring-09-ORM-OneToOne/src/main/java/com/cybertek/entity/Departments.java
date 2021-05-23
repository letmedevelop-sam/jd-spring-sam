package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "departmentTable")
public class Departments {
    @Id
    private String department;
    private String division;
}
