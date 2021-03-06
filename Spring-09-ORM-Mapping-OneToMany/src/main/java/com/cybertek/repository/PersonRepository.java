package com.cybertek.repository;

import com.cybertek.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    //so far we just need to create PersonRepository because uni directional we use Person class

}
