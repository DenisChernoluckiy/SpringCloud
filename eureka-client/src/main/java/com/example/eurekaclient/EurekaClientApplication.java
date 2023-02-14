package com.example.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHystrix
public class  EurekaClientApplication {

	private static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
