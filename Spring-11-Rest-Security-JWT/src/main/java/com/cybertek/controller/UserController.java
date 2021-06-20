package com.cybertek.controller;

import com.cybertek.entity.ResponseWrapper;
import com.cybertek.entity.User;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@EnableGlobalMethodSecurity(prePostEnabled = true)  //First step : enable
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/read")
 //   @PreAuthorize("hasAuthority('USER')")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')") // Second step : pre authorize
    public ResponseEntity<ResponseWrapper> readAll(){

        List<User> users = userService.getAll();

        return ResponseEntity.ok(new ResponseWrapper("Done",users));

    }
}

//WATCH the DEBUG in Day-38 last 8 minutes

//Test from Postman

// go to postman POST http://localhost:8080/authenticate
//get the token and insert it to HEADER of your request in Authorization part
// GET  http://localhost:8080/api/v1/users/read

/*
{
    "success": true,
    "message": "Done",
    "code": 200,
    "data": [
        {
            "id": 1,
            "isDeleted": false,
            "email": "admin@admin.com",
            "username": "admin",
            "role": "ADMIN",
            "isVerified": true,
            "state": "ACTIVE"
        }
    ]
}
 */