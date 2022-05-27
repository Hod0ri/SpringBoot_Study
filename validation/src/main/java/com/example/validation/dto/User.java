package com.example.validation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class User {
    @NotBlank
    private String name;
    @Min(value = 0)
    @Max(value = 90)
    private int age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식을 맞춰주세요 : xxx-xxx(x)-xxxx")
    private String phoneNumber;
}
