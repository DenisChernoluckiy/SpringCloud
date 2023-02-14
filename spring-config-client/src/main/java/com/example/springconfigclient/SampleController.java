package com.example.springconfigclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Value("${spring.datasource.url}")
    private String data;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.jpa.database}")
    private String dbName;

    @Value("${server.port}")
    private String port;

    @GetMapping("/anonymous")
    public String getAnonymousInfo() {
        return data;
    }

    @GetMapping("/dbname")
    public String getUserInfo() {
        return dbName;
    }

    @GetMapping("/port")
    public String getAdminInfo() {
        return port;
    }

    @GetMapping("/logInfo")
    public String getServiceInfo() {
        return "username: " + username + " \n" +
                "password: " + password;
    }
}
