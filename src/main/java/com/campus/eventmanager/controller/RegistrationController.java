package com.campus.eventmanager.controller;

import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public Registration register(
            @RequestParam Long userId,
            @RequestParam Long eventId) {

        return registrationService.registerUser(userId, eventId);
    }
}