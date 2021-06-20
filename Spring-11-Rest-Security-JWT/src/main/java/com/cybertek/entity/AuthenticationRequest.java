package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationRequest { //we created this class because this username and password will do the authentication

    private String username;
    private String password;
}
