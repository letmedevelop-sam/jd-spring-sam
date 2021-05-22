package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Value("JD1")         //This is Hard Coded -> we assign a value.
    private String batch;

    @Value("${instructor}")     // This will come from properties file. We need to describe in config file
    private String instructor;

    @Value("${days}")           // This will come from properties file.
    private String[] days;

/*    @Override
    public String toString() {       //to be able to print   alt+INS and create toString method //also we have lombok
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                ", extraSessions=" + extraSessions +
                '}';*/




    private ExtraSessions extraSessions;

    @Autowired        //we dont have to use if there is only one  //also due to lombok
    public Java(@Qualifier("officeHours")ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    /*
        ****************
        1.Constructor,
    @Autowired        //we dont have to use if there is only one  //also due to lombok
    public Java(@Qualifier("officeHours")ExtraSessions extraSessions) {
    this.extraSessions = extraSessions;
    }
    *********************
            2.Setter,
      available but not makes sense
      * Mostly use constructor
      *
    *********************
            3.Field Injections
    @Autowired
    @Qualifier("officeHours")
    private ExtraSessions extraSessions;
     */
    @Override
    public void getTeachingHours() {
            System.out.println("Weekly Java Teaching Hours : " + (30 + extraSessions.getHours()));

    }
}
