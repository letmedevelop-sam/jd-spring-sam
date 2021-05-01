package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Selenium implements Course {
    public void getTeachingHours() {

            System.out.println("Weekly Selenium Teaching Hours : 23");

    }
}
