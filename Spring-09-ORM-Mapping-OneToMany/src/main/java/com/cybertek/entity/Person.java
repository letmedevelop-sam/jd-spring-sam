package com.cybertek.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "person")
    private List<Address> addresses;  //'One To Many' attribute type should be a container, so we need to use collection

    /*
    We can do it in a different way as well =>

    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Address> addresses;
    */

}
