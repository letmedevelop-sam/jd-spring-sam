package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java implements Course {

    @Override
    public void getTeachingHours() {


            System.out.println("Weekly Java Teaching Hours : 30");

    }
}
