package com.example.eurekaclient2;

import jakarta.ws.rs.core.Application;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EurekaClient2Application {

    private static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class, args);
    }
}
