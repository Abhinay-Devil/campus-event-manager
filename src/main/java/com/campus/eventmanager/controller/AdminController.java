package com.campus.eventmanager.controller;

import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.response.ApiResponse;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<Map<String, Long>>> getStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("users", userRepository.count());
        stats.put("events", eventRepository.count());
        stats.put("registrations", registrationRepository.count());

        return ResponseEntity.ok(ApiResponse.success("Statistics retrieved successfully", stats));
    }
}
