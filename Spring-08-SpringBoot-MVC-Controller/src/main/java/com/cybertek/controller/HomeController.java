package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //Business Logic will happen here. Controller is coming from this structure. Bean will be created from here
public class HomeController {
    //income request is coming
    //no limit for number of controllers
    //we may have hundreds of classes, we send request
    //Front controller will look for it, but where?   @RequestMapping annotation will do it. It can be class level or method level

    @RequestMapping("/")
    public  String getRequestMapping(){
    //This method  will look for where to go, so use  @RequestMapping annotation
        return  "home";
    }

    //after income request, a template will return

    @RequestMapping(method = RequestMethod.GET, value ="/sam")
    public  String getRequestMapping2(){
        return  "home-sam";
    }
//method name DOES NOT MATTER. it is looking for the end point in annotation
//we use GET and POST for UI. For REST we will use more...

    @RequestMapping(method = RequestMethod.POST, value ="/cybertek")
    public  String getRequestMapping3(){
        return  "home-cybertek";
    }

    @GetMapping("/spring")
    public String getMappingEx(){
        return "spring";
    }

//    @GetMapping("/spring")
//    public String getMappingEx2(){
//        return "home";
//    }

    //In API we will use this structure a lot we will retrieve endpoint for URI
    @GetMapping("/home/{department}")         //using {  ccc }  will let us use any name as parameter
    public String pathVariableEx(@PathVariable("department") String deptName){
        System.out.println("Name given in the URI is  : " + deptName);
        return "home-variable";
    }

    //This code will bring some data from UI to java
    @GetMapping("/home/{department}/{section}")         //using {  ccc }  will let us use any name as parameter
    public String pathVariableEx2(@PathVariable("department") String deptName, @PathVariable("section") String sectName){
        System.out.println("The department name given in the URI is  : " + deptName);
        System.out.println("The  section  name  given in the URI is  : " + sectName);
        return "home-variable-sub";
    }


}
