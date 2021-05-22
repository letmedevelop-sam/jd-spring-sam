package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

 /*
• If more than one bean of the same type is available in the container,
the framework will
throw NoUniqueBeanDefinitionException, indicating that more than
one bean is available for autowiring.
• @Qualifier annotation along with @Autowired can be used to
remove the confusion by specifying which exact bean will be wired.
• Can be applied to :
        1.Constructor,
        2.Setter,
        3.Field Injections
 */

        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
        Course courseJava = container.getBean("java", Course.class); // we lowercase the ClassName and use it like java

       // courseJava.toString();  //It will not run because not void
        System.out.println("courseJava.toString() = " + courseJava.toString());


/*      Course courseSelenium = container.getBean("selenium", Course.class);
        courseSelenium.getTeachingHours();
*/




    }
}
