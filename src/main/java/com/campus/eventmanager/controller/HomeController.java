package com.campus.eventmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Developed BY Abhinay Srivastava 

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Backend is Running ";
    }
}
