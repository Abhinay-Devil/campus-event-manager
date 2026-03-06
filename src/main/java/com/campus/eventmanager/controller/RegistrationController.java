package com.campus.eventmanager.controller;

import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.service.RegistrationService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/events/{eventId}/register")
    @PreAuthorize("hasRole('STUDENT')")
    public Registration register(@PathVariable Long eventId,
            @RequestParam Long userId) {
        return registrationService.registerUser(userId, eventId);
    }
}
// Developed BY Abhinay Srivastava
