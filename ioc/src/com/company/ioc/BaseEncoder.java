package com.company.ioc;

import java.util.Base64;

public class BaseEncoder implements IEncoder{
    @Override
    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}
