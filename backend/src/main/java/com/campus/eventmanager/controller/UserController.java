package com.campus.eventmanager.controller;

import org.springframework.web.bind.annotation.*;
import com.campus.eventmanager.model.User;
import com.campus.eventmanager.service.UserService;
import org.springframework.security.core.Authentication;
import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.response.ApiResponse;

import java.util.List;

import com.campus.eventmanager.dto.UserDTO;
import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.repository.RegistrationRepository;
import org.springframework.http.ResponseEntity;

// Developed BY Abhinay Srivastava

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RegistrationRepository registrationRepository;

    public UserController(UserService userService, UserRepository userRepository, RegistrationRepository registrationRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(ApiResponse.success("User created successfully", createdUser));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success("Users retrieved successfully", users));
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<User>> getMyProfile(Authentication authentication) {

        if(authentication == null){
            throw new RuntimeException("User not authenticated");
        }

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(ApiResponse.success("Profile retrieved successfully", user));
    }

@GetMapping("/me/registrations")
public ResponseEntity<ApiResponse<List<Registration>>> getMyRegistrations(Authentication authentication) {

    String email = authentication.getName();

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    List<Registration> registrations = registrationRepository.findByUser_Id(user.getId());
    return ResponseEntity.ok(ApiResponse.success("Registrations retrieved successfully", registrations));
}

}
