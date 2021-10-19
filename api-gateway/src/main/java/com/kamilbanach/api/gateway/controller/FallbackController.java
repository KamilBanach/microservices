package com.kamilbanach.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod() {
        return "User Service is taking longer than expected";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod() {
        return "Department Service is taking longer than expected";
    }

    @GetMapping("/addressServiceFallback")
    public String addressServiceFallbackMethod() {
        return "Address Service is taking longer than expected";
    }
}
