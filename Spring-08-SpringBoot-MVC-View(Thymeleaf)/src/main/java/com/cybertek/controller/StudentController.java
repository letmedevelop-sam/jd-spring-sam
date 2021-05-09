package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {


    @GetMapping("/welcome")
    public String homePage(Model model){//This method will carry data from this class to HTML page //BINDING DATA MODEL

        model.addAttribute("name", "Sam"); // we have to add 2 parameters 1: attribute name 2: attribute value

        model.addAttribute("course", "Java Developer");

        String subject = "Collections";

        model.addAttribute("subject", subject);

        //create some random student ID (0-1000) and show it in your UI

        Random random = new Random();
        int studentID = random.nextInt(1000);

        model.addAttribute("studentID", studentID);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);

        model.addAttribute("numbers", numbers);

        //print your birthday
        LocalDate birthday = LocalDate.now().minusYears(43);

        model.addAttribute("birthday", birthday);



        return "student/welcome";
    }

}
