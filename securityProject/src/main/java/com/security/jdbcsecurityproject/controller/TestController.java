package com.security.jdbcsecurityproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin")
    public String admin(){
        return"hello admin";
    }
    @GetMapping("/user")
    public String user(){
        return"hello user";
    }
    @GetMapping
    public String guest(){
        return"hello guest";
    }
}
