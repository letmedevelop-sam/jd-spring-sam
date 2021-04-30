package com.cybertek.services;

import com.cybertek.interfaces.Course;


public class Selenium implements Course {
    private OfficeHours officeHours; //We can use ExtraSessions interface. //It will be a better practice

    /*
    we can use alt + ins to generate setter or we can use lombok
    to use lombok we need to add dependency
    we can use only @Setter or @Data to bring getter, setter, toString etc all together in one shot
     */

    public OfficeHours getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;

        /*
        the method name except the set part will be the property name
        The parameter (the object name) will be the ref part of the setter injection
        <property name="officeHours" ref = "officeHours"/>
         */
    }

    @Override
    public void getTeachingHours() {

        System.out.println("Weekly Teaching Hours : " + (15 + officeHours.getHours()));
        System.out.println("In addition to 15 Selenium hours,  Additional " + officeHours.getHours() + " is coming from officeHours");
    }
}
