package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mentor") //If there is same mapping in different classes we add parameter
//http://localhost:8080/show    //this URI will not work    "Whitelabel Error Page"
//This application has no explicit mapping for /error, so you are seeing this as a fallback.
//http://localhost:8080/student/show    //this will be correct URI
public class MentorController {
    //Controller can be different. It will go to same home
    @RequestMapping("/show")
    public String showForm(){
        return "home";
    }
}
