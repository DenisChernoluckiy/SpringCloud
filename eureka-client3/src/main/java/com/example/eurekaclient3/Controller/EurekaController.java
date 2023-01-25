package com.example.eurekaclient3.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/main")
public class EurekaController {

    @GetMapping("/test/{name}")
    public String testMethod(@PathVariable String name) {
        String greeting = "Hello " + name + ", glad to see u!";
        return greeting;
    }
}
