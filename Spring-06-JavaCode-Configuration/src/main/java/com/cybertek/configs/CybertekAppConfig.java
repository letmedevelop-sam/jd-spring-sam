package com.cybertek.configs;

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

Finally, go to CybertekApp:
 ApplicationContext container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);

 giving the configuration Java class is important                    //(CybertekAppConfig.class);

 old one was: but now no xml needed
 ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
     */

}
