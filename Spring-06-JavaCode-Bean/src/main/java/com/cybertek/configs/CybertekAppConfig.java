package com.cybertek.configs;

import com.cybertek.services.Java;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cybertek")
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
In case we are not able to add related classes @Component annotation we can create methods with @Bean annotations which will provide us Beans


Finally, go to CybertekApp:
 ApplicationContext container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

 giving the configuration Java class is important                    //(CybertekAppConfig.class);

 old one was: but now no xml needed
 ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
     */

    @Bean
    public Java java(){
        return new Java();

    }
    @Bean
    public Selenium selenium(){
        return new Selenium();
    }
}
