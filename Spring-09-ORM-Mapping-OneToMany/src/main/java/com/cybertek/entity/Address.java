package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

    @Id
    private Long id;

    private String street;
    private String zipCode;

    @ManyToOne    //mapped by can not be used in ManyToOne
    private Person person;
}
