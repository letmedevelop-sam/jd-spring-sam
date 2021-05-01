package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class API implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly API Teaching Hours : 15");
    }
}
