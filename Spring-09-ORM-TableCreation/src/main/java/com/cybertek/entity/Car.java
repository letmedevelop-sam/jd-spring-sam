package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity          // I want a Car table. It will have id, make and model columns
public class Car {

    @Id
    private int id;
    private String make;
    private String model;


}
