package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class Java implements Course {

    @Value("JD1")
    private String batch;

    @Value("${instructor")
    private String instructor;

    @Value("${days}")
    private String [] days;


    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Java Teaching Hours : 30");
    }
}
