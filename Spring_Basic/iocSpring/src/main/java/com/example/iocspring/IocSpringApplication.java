package com.example.iocspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocSpringApplication.class, args);

        String url = "www.daelim.ac.kr/dept/computerinfo?details=software&sessionID=4444";

        ApplicationContext context = ApplicationContextProvider.getContext();

        // BaseEncoder baseEncoder = context.getBean(BaseEncoder.class);
        // UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);

        // Encoder encoder = context.getBean("base64d",Encoder.class);
        Encoder encoder = context.getBean("urld",Encoder.class);

        String result = encoder.encode(url);
        System.out.println(result);
    }

}
