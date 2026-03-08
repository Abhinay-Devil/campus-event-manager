package com.campus.eventmanager.controller;

import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.campus.eventmanager.model.User;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @DeleteMapping("/{eventId}/cancel")
public ResponseEntity<String> cancelRegistration(
        @PathVariable Long eventId,
        Authentication authentication) {

    User user = (User) authentication.getPrincipal();

    registrationService.cancelRegistration(eventId, user.getId());

    return ResponseEntity.ok("Registration cancelled successfully");
}


    @PostMapping("/{eventId}/register")
   // @PreAuthorize("hasRole('STUDENT')")
    public Registration register(@PathVariable Long eventId){
        return registrationService.register(eventId);
    }


}

// Developed BY Abhinay Srivastava
