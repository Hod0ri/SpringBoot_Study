package com.example.iocspring;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base64ec")
public class BaseEncoder implements IEncoder{
    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}
