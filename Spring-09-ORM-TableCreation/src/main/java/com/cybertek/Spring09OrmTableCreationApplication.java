package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Spring09OrmTableCreationApplication {

    @Autowired
    CarRepository carRepository;  //we inject our Repo and it will have access to all methods

    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmTableCreationApplication.class, args);
    }

    @PostConstruct      //it will run once and before everything.
    public void dataInit(){

        Car c1 = new Car("BMW", "M5");
        Car c2 = new Car("VW", "M3");
        Car c3 = new Car("AUDI", "A6");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

        //We mapped our object to the DB and we filled our values to Table Data
        //we used   JPA repository methods @Repository
        //now save, delete, save all (for lists)

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW1", "M5"));
        cars.add(new Car("BMW2", "M5"));
        cars.add(new Car("BMW3", "M5"));
        carRepository.saveAll(cars);



    }


}
