package com.cybertek.entity;

import javax.persistence.*;

@Entity          // I want a Car table. It will have id, make and model columns. Adding annotation started relational mapping
@Table(name = "cars")
public class Car {

    @Id
    private int id;

    private String make;
    private String model;


}
