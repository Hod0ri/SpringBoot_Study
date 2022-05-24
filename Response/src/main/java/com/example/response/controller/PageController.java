package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main() {
        return "main.html";
    }

    @ResponseBody
    @GetMapping("/user")
    public User user() {
        // User user = new User() : 타입 추론
        var user = new User();
        user.setName("Admin");
        user.setAddress("Daelim UC");

        return user;
    }
}
