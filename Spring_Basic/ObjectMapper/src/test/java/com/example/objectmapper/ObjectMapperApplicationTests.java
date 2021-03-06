package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("------------------------");

        var objectMapper = new ObjectMapper();

        // object -> Text
        // Object Mapper GET Method 활용
        var user = new User("Alex", 20, "010-1234-1234");

        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);
        System.out.println("------------------------");

        // text -> Object
        // Object Mapper는 default Constructer를 활용
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
        System.out.println("------------------------");
    }

}
