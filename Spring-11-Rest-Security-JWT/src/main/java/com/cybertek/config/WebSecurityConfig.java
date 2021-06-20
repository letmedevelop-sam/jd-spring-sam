package com.cybertek.config;

import com.cybertek.service.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {   //this is first step to enable Security

    @Autowired
    private SecurityFilter securityFilter;

    @Override
    @Bean                                                               //create BEAN to be able to handle methods. Because there is no FORM
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] permittedUrls ={              //set permissions

            "/authenticate",
            "/create-user",
            "/api/p1/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/webjars/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .csrf()
                .disable()      //we disable the auto protection. Otherwise as We are using different server 8080 and it will be realized as an attack
                .authorizeRequests()
//                .antMatchers("/authentication") //This will let everyone  in      //    http://localhost:8080/authentication POST
                .antMatchers(permittedUrls)
                .permitAll()
                .anyRequest()
                .authenticated();

        http.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class); // app knows who is the user


    }

    //test with     http://localhost:8080/authenticate

    /*
    {
        "username":"admin",
        "password":"admin"
    }

    {
    "success": true,
    "message": "Login Succesfull!",
    "code": 200,
    "data": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYyNDIyMzE0MSwiaWF0IjoxNjI0MTg3MTQxLCJlbWFpbCI6ImFkbWluQGFkbWluLmNvbSIsInVzZXJuYW1lIjoiYWRtaW4ifQ.rezNWrcSCLrtaTELpoR8TGKM6-fBT6cDhbFNJU5p16s"
}
     */
}
