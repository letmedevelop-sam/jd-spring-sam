package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Java implements Course {


    @Autowired
    private OfficeHours officeHours; //there is no connection between Java and OfficeHours yet

    //It is always better to use the Interface
    //private ExtraSessions extraSessions;
    //If you have 2 classes implementing that Interface we will use @Qualifier



    /*
    There are 3 ways of using @Autowired annotation
    Most preferred one is Constructor Injection
    *******************
    1. We can create constructor and add @Autowired annotation on top of that
    This is called Constructor Injection
    If there is only one constructor, even you dont add  @Autowired it will work
    If you have lombok dependency and @AllArgsConstructor it will be same

       @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    ********************
    2. Setter Injection
    It is not preferred.
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }
    *******************
    3. Field Injection
    We can just add @Autowired annotation over the field

    @Autowired
    private OfficeHours officeHours;

     */

    public void getTeachingHours() {

        System.out.println("Weekly Java Teaching Hours : " + (30 + officeHours.getHours()) + " -including the Office Hours- ");
    }


}
