package com.cybertek.configs;

import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")

/*
@PropertySource()
we tell the spring which file to bring values to us  -->> "classpath:application.properties"

            Previously we were doing it by config.xml
            <contex:property-placeholder location="classpath:application.properties"/>

Later Spring boot will do it.

 */
public class CybertekAppConfig {

    /*
    First thing we do is add annotations
@Configuration
@ComponentScan
then tell spring the package where to look for beans
@ComponentScan("com.cybertek")

Then it will go and look for @Component Annotations in the classes
If there is no annotation you will receive :
Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'java' available
Instead of adding all classes @Component annotation we can create methods with @Bean annotations which will provide us Beans


Finally, go to CybertekApp:
 ApplicationContext container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

 giving the configuration Java class is important                    //(CybertekAppConfig.class);

 old one was: but now no xml needed
 ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
     */

    @Bean                               //we dont use the @Component in the Java class
    public Java java(){
        return new Java(extraSessions());   //for the injection we need to add parameter. It is coming from our Java class param constructor

    }
    @Bean
    public Selenium selenium(){

        return new Selenium();
    }

 /*   @Bean                                     //NOT mandatory @Bean due to injection
    public OfficeHours officeHours(){            //TIGHTLY COUPLED
        return new OfficeHours();
    }*/


    @Bean                           //NOT mandatory @Bean  due to injection
    public ExtraSessions extraSessions(){         //LOOSELY COUPLED
        return new OfficeHours();               //POLYMORPHIC WAY    ExtraSessions ex = new OfficeHours();
    }
}
