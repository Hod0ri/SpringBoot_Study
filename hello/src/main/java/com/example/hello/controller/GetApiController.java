package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello")  // http://localhost:9090/api/get/hello
    public String getHello() {
        return "Get Hello";
    }

    @RequestMapping(path="/hi", method = RequestMethod.GET) // Request Mapping 방식
    public String hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name="name") String pathName) {
        System.out.println("Path Variable : " + pathName);
        return pathName;
    }

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String ,String> queryParam) {

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    // 쿼리 파라미터 지정
    @GetMapping("/query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
        ) {
        System.out.println(name + " : " + email + " -> " + age);
        return name + " : " + email + " -> " + age;
    }

    // dto 객체 사용
    // 쿼리 파라미터로 들어온 값을 객체와 매칭
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName() + " : " + userRequest.getEmail() + " -> " + userRequest.getAge());
        return userRequest.toString();
    }


}
