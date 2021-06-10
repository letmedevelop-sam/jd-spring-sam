package com.cybertek.controller;

import com.cybertek.entity.Account;
import com.cybertek.entity.Cinema;
import com.cybertek.entity.User;
import com.cybertek.repository.AccountRepository;
import com.cybertek.repository.CinemaRepository;
import com.cybertek.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private CinemaRepository cinemaRepository;

    public HomeController(UserRepository userRepository, AccountRepository accountRepository, CinemaRepository cinemaRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
    }

    @GetMapping("/users")
    public List<User> readAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> readAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/cinemas")
    public List<Cinema> readAllCinemas(){
        return cinemaRepository.findAll();
    }
}
