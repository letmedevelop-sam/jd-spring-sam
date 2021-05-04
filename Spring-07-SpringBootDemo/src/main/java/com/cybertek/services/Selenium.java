package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {


    @Value("${instructor}")
    private  String instructorName;
    private ExtraSessions extraSessions;

    public Selenium(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public int getTeachingHours() {
        return 10 + extraSessions.getHours();
    }

    @Override
    public void courseInfo() {
        if(extraSessions.getHours()>0){
            System.out.println("Java Teaching Hours : " + extraSessions.getHours() + " including Office Hours");
        }else {
            System.out.println("Java Teaching Hours : " );
        }
        System.out.println("Java instructor is : " + instructorName);
    }
}
