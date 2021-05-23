package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
/*
    @OneToMany(mappedBy = "person")
    private List<Address> addresses;  //'One To Many' attribute type should be a container, so we need to use collection
*/
    /*
    We can do it in a different way as well =>

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Address> addresses;
    */
/*

    case - 1 create address then create person. person id in address will be null

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<Address> addresses;
*/
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//we will try again and we need to open @ManytoOne line 22 in Address class
    //@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)   WILL CHANGE AS BELOW

    @OneToMany(mappedBy = "person") //We dont need    cascade = CascadeType.ALL    part
    private List<Address> addresses;



}
