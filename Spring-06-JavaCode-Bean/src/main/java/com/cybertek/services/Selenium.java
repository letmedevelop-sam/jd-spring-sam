package com.cybertek.services;

import com.cybertek.interfaces.Course;


public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Selenium teaching hours : 22");
    }
}
