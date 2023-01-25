package com.example.eurekaclient.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "EUREKA-CLIENT2", path = "/api/order")
public interface EurekaClient2FeignClient {

    @GetMapping("/notify")
    String doOrder(@RequestParam String order,
                   @RequestParam String customer);
}
