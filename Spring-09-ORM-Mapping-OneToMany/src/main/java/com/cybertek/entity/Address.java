package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String zipCode;
/*
    //foreign key will come from ManyToOne
    @ManyToOne    //mapped by can not be used in ManyToOne
    private Person person;

 */

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }


}
