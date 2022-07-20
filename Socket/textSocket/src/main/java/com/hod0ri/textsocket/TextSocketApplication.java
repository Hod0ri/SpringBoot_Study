package com.hod0ri.textsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class TextSocketApplication {

    // 웹 소켓을 사용하기 위한 Bean 객체
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
    public static void main(String[] args) {
        SpringApplication.run(TextSocketApplication.class, args);
    }

}
