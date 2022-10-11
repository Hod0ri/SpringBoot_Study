package com.hod0ri.oauth2google.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/restricted")
    public String restricted() {
        return "Restricted";
    }
}
