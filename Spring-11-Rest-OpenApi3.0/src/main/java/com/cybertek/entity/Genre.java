package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genre extends BaseEntity{

    private String name;

    @ManyToMany(mappedBy = "genreList")                 //It can be uni-directional or multi-directional
    private List<Movie> movieList = new ArrayList<>();

    //IF YOU WORK WITH data.sql THEN YOU DONT NEED TO CREATE CONSTRUCTORS
    public Genre(String name) {
        this.name = name;
    }
}
