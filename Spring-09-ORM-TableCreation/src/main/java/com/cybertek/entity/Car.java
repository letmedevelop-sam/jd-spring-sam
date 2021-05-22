package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity          // I want a Car table. It will have id, make and model columns. Adding annotation started relational mapping
@Table(name = "cars")
@NoArgsConstructor// add lombok to create a n object  / constructor to add something to our table
//@AllArgsConstructor  //we removed @AllArgsConstructor  bc of ID issue
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this will generate id for us
    private int id;

    private String make;
    private String model;

    public Car(String make, String model) {  //as id will be generated automat,cally we will cretae another constructor without ID
        this.make = make;
        this.model = model;
    }
}
