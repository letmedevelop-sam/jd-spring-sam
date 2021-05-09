package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



        return "student/welcome";
    }

}
