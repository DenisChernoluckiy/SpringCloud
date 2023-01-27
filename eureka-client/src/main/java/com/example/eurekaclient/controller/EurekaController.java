package com.example.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@RequestMapping("/api/order")
public class EurekaController {

    @Autowired
    private EurekaClient2FeignClient feignClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @GetMapping("/send")
    public String sendOrder(@RequestParam String order,
                            @RequestParam String customer) {

        String response = circuitBreakerFactory.create("feignClient").run(() -> feignClient.doOrder(order, customer),
                r -> "Oops... something went wrong during registration your order");

        return response;
    }

    @GetMapping("/2send")
    public String secondSendOrder(@RequestParam String order,
                            @RequestParam  String customer) {
        return circuitBreakerFactory.create("feignClient")
                .run(() -> feignClient.doOrder(order, customer),
                        throwable -> fallbackOrder(order, customer));
    }

    public String fallbackOrder(@RequestParam String order,
                                @RequestParam  String customer) {
        return "Fallback Order: " + order + " for customer: " + customer + " is denied";
    }

  /*  @Autowired
    private EurekaClient2FeignClient feignClient;

    @Autowired
    private CircuitBreakerFactory cbFactory;

    @GetMapping("/send")
    public String sendOrder(@RequestParam String order,
                            @RequestParam  String customer) {
        return cbFactory.create("feignClient")
                .run(() -> feignClient.doOrder(order, customer),
                        throwable -> fallbackOrder(order, customer));
    }

    public String fallbackOrder(@RequestParam String order,
                                @RequestParam  String customer) {
        return "Fallback Order: " + order + " for customer: " + customer + " is denied";
    }*/

    /*@Autowired
    private EurekaClient2FeignClient feignClient;

    private CircuitBreakerFactory cbFactory;

    @GetMapping("/send")
    @CircuitBreaker(name = "feignClient",
            fallbackMethod = "fallbackOrder")
    public String sendOrder(@RequestParam String order,
                            @RequestParam  String customer) {
        System.out.println("Get order: " + order);
        String transferOrder = order;
        String transferCustomer = customer;
        feignClient.doOrder(transferOrder, transferCustomer);
        return feignClient.doOrder(transferOrder, transferCustomer);
    }
    public String fallbackOrder(@RequestParam String order,
                                @RequestParam  String customer) {
        return "Fallback Order: " + order + " for customer: " + customer + "is denied";
    }

    @GetMapping("/test")
    public String hello() {
        return "hello";
    }*/
}
