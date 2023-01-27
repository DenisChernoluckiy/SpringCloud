package com.example.eurekaclient2.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class EurekaController {

    @GetMapping("/notify")
    public String doOrder(@RequestParam String order,
                          @RequestParam String customer) {

        Integer orderNumber = OrderNumberGenerator.orderNumberGenerator();

        return "Order number: " + orderNumber + " has been taken processed; \n"  +
                "Order contains: " + order + "; \n" +
                "Customer: " + customer;
    }
}
