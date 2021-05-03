package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;


public class Java implements Course {


    private ExtraSessions extraSessions;

    @Autowired                                                                          //can keep it or skip it
    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Java teaching hours : " + (30 + extraSessions.getHours()) + " including the  Office Hours");

    }

    @Value("JD1")               //This is a sample for hard coded value
    private String batch;

    @Value("${instructor}")     //This will bring value from our application.properties file
    private  String instructor;

    @Value("${days}")     //This will bring value from our application.properties file
    private String[] days;


    @Override
    public String toString() {
        return "Java{" +
                                "Batch='" + batch + '\'' +
                ", Instructor='" + instructor + '\'' +
                ", Days=" + Arrays.toString(days) +
                '}';
    }
}
