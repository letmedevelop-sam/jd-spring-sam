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

WE COMMENTED OUT TO TRY @JoinColumn line 34 in Person class
 */

    public Address(String street, String zipCode) {
        this.street = street;
        this.zipCode = zipCode;
    }

//we will use again for case - 2   //this time we will add    (cascade = CascadeType.ALL)
   // @ManyToOne(cascade = CascadeType.ALL)    //mapped by can not be used in ManyToOne

    //we could not see the second address. So we will delete cascade
    @ManyToOne
    private Person person;
}
