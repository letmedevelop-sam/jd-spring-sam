package com.cybertek.entity;

import com.cybertek.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "account_details")
@ToString
                        //If we receive some unknown data , ignoreUnknown = true will ignore it
@JsonIgnoreProperties(value = {"state", "postalCode"}, ignoreUnknown = true)  //If you dont want to show them in JSON format
public class Account extends  BaseEntity{

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;

    @Column(name = "postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @OneToOne(mappedBy = "account")
    @JsonBackReference      //Json igmore will do similar.  @JasonManagedReference will be on the other entity
    private User user;

    public Account(String name, String address, String country, String state, String city, Integer age, String postalCode, UserRole role) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.age = age;
        this.postalCode = postalCode;
        this.role = role;
    }
}
