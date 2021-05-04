package com.cybertek;

import com.cybertek.calculator.Calculator;
import com.cybertek.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07CarpetAssignmentApplication {

    public static void main(String[] args) throws Exception {

        // just add ApplicationContext container =
        ApplicationContext container = SpringApplication.run(Spring07CarpetAssignmentApplication.class, args);
        Calculator calculator = container.getBean("calculator", Calculator.class);

        System.out.println(calculator.getTotalCarpetCost(City.ARLINGTON));

    }

}
