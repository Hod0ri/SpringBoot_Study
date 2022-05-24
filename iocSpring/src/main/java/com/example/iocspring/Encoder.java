package com.example.iocspring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class Encoder {
    private IEncoder iEncoder;

    // @Component 사용
    // public Encoder(@Qualifier("base64ec") IEncoder iEncoder) {
    //     this.iEncoder = iEncoder;
    // }

     public Encoder(IEncoder iEncoder) {
         this.iEncoder = iEncoder;
     }

    public void setiEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}

@Configuration
class AppConfig {
    @Bean("base64d")
    public Encoder encoder(BaseEncoder baseEncoder) {
        return new Encoder(baseEncoder);
    }

    @Bean("urld")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}

