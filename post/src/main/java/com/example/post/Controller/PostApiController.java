package com.example.post.Controller;

import com.example.post.dto.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @PostMapping("/post2")
    public void post2(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest.getAccount() + " : " + userRequest.getEmail());
        System.out.println(userRequest.getEmail() + " : " + userRequest.getAddress());
        System.out.println(userRequest.getPhoneNumber() + " : " + userRequest.getOTP());
    }
}
