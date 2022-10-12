package com.hod0ri.studyservice;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email) {

}
