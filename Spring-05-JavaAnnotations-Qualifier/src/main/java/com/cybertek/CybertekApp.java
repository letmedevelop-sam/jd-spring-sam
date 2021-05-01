package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course courseJava = container.getBean("java", Course.class); // we lowercase the ClassName and use it like java
        courseJava.getTeachingHours();
        Course courseSelenium = container.getBean("selenium", Course.class);
        courseSelenium.getTeachingHours();

    }
}
