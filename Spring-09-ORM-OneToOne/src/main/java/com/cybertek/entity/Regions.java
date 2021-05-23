package com.cybertek.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "regionsTable")
public class Regions {
    @Id
    private int regionId;
    private  String region;
    private String country;


}
