package com.campus.eventmanager.controller;

import com.campus.eventmanager.dto.RegistrationDTO;
// import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.model.User;
import com.campus.eventmanager.service.RegistrationService;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.response.ApiResponse;

import java.util.Objects;

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
public ResponseEntity<ApiResponse<Void>> cancelRegistration(
        @PathVariable @NonNull Long eventId,
        Authentication authentication) {

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    String email = userDetails.getUsername();

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    registrationService.cancelRegistration(eventId, Objects.requireNonNull(user.getId()));

    return ResponseEntity.ok(ApiResponse.success("Registration cancelled successfully", null));
}


    @PostMapping("/{eventId}/register")
   // @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<ApiResponse<RegistrationDTO>> register(@PathVariable @NonNull Long eventId){
    RegistrationDTO registration = registrationService.register(eventId);
    return ResponseEntity.ok(ApiResponse.success("Registration successful", registration));
}


}

// Developed BY Abhinay Srivastava
