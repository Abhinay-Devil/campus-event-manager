package com.campus.eventmanager.controller;

import com.campus.eventmanager.dto.RegistrationDTO;
// import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.service.RegistrationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.campus.eventmanager.model.User;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;
import com.campus.eventmanager.repository.UserRepository;


@RestController
@RequestMapping("/api/events")
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserRepository userRepository;

    public RegistrationController(RegistrationService registrationService, UserRepository userRepository) {
        this.registrationService = registrationService;
        this.userRepository = userRepository;
    }


    @DeleteMapping("/{eventId}/cancel")
public ResponseEntity<String> cancelRegistration(
        @PathVariable Long eventId,
        Authentication authentication) {

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    String email = userDetails.getUsername();

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    registrationService.cancelRegistration(eventId, user.getId());

    return ResponseEntity.ok("Registration cancelled successfully");
}


    @PostMapping("/{eventId}/register")
   // @PreAuthorize("hasRole('STUDENT')")
    public RegistrationDTO register(@PathVariable Long eventId){
    return registrationService.register(eventId);
}


}

// Developed BY Abhinay Srivastava
