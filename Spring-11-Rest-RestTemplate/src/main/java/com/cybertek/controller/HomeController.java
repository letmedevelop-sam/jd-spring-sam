package com.cybertek.controller;

import com.cybertek.entity.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeController {

    final String URI = "https://jsonplaceholder.typicode.com/users";

    private RestTemplate restTemplate;

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){                   //RestTemplate will go to the API, grab all info in Json and convert it to our User entity
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI,User[].class);        //will return Array
        return responseEntity.getBody();    //this method is coming from RestTemplate
    }

    //test with a certain id
    @GetMapping(value = "/{id}")
    public Object readUser(@PathVariable("id") Integer id){
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL,Object.class,id);
        //Manually Test in Postman
        //http://localhost:8080/9
    }


    //Manually Test in Postman
    //https://dummyapi.io/data/api/user?limit=10
    //App ID header is missing

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostsFromDummyApi(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","lTE5abbDxdjGplutvTuc");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/api/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;
   }

    //Manually Test in Postman
   //http://localhost:8080/test
}
