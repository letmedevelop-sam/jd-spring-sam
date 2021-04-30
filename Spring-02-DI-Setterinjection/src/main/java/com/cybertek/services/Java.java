package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.Data;


@Data
public class Java implements Course {

   private OfficeHours officeHours;

    public OfficeHours getOfficeHours() {   //getter method auto generated // we can also use lombok @Getter
        return officeHours;
    }

    public void setOfficeHours(OfficeHours officeHours) { //setter method auto generated // we can also use lombok @Getter

        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (20 + officeHours.getHours()));
        System.out.println("In addition to 20 java hours Additional " + officeHours.getHours() + " is coming from officeHours");
    }
}
