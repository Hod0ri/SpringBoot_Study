package com.hod0ri.studyservice.service;

import com.hod0ri.studyservice.CustomerRegistrationRequest;
import com.hod0ri.studyservice.model.Customer;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

    }
}
