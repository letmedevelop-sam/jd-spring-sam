package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor  //As we created param constructor we also need to create no args constructor
public class Employee extends BaseEntity{

    //id will be inherited from BaseEntity
    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
//    private String department;        //This column will come from JOIN

    @Enumerated (EnumType.STRING)
    private Gender gender;
    private int salary;
//    private int regionId;         //This column will come from JOIN

    //create constructor
    public Employee(String firstName, String lastName, String email, LocalDate hireDate, Gender gender, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.gender = gender;
        this.salary = salary;
    }
}
