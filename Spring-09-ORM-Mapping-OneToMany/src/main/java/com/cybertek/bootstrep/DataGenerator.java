package com.cybertek.bootstrep;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;


    @Override
    public void run(String... args) throws Exception {

        Person p1  = new Person("Sam", "Kar");
        Person p2  = new Person("Bil", "Bar");
        Person p3  = new Person("Kim", "Sar");

        Address a1 = new Address("YGC St", "21090");
        Address a2 = new Address("Elm St", "31090");
        Address a3 = new Address("Java St", "41090");

 /*
       //  p1.setAddresses(Arrays.asList(a1,a2));
       //this was case - 1
       //created address then create person. person id in address will be null

        personRepository.save(p1);

  */

        //We need to assign some persons to address

        personRepository.save(p1); // first we save person

        //then we a assign some addresses to this persons
        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);

        //then we save addresses
        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);





    }
}
