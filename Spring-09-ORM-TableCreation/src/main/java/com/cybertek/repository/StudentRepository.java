package com.cybertek.repository;

import com.cybertek.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    //we can also create our own methods but they are already existing

}
