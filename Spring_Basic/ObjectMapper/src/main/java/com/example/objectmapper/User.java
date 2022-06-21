package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;
}
