package com.example.journalAPP.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    public HealthCheck() {
        System.out.println("I am in health check");
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "OK".toLowerCase() ;
    }
}
