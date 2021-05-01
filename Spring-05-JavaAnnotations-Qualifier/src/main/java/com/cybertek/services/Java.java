package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Java implements Course {

    private ExtraSessions extraSessions;
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
      * Mostly use constructır
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
