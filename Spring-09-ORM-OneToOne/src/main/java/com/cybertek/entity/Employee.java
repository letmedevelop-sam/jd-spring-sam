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

                //cascade ALL will tell Hibernate when you do something in one table, go and do the same in the other table
    @OneToOne(cascade = CascadeType.ALL) //For taking not all of them use one by one {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}
    @JoinColumn(name = "departmentID")
    private Department department; //it is complaining and we need to add @OneToOne annotation to describe how tables will join (one Emp will work in One Dept

    @Enumerated (EnumType.STRING)
    private Gender gender;
    private int salary;
//    private int regionId;         //This column will come from JOIN

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //fetch = FetchType.LAZY do when needed  or else fetch = FetchType.EAGER
    @JoinColumn(name = "regionId")
    private Region region;

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
