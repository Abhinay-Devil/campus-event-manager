package com.campus.eventmanager.controller;

import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.service.RegistrationService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/{eventId}/register")
    @PreAuthorize("hasRole('STUDENT')")
    public Registration register(@PathVariable Long eventId){
        return registrationService.register(eventId);
    }
}

// Developed BY Abhinay Srivastava
