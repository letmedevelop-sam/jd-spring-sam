package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

public class Java implements Course {

   // OfficeHours officeHours;
    //to keep it more efficient and Loosely Coupled create obj from Extra Session
    ExtraSessions extraSessions;
/*
Also create constructor again
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
*/

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours())); //also change officeHours
    }
}
