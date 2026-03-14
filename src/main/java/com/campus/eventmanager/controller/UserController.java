package com.campus.eventmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.campus.eventmanager.model.User;
import com.campus.eventmanager.service.UserService;
import org.springframework.security.core.Authentication;
import com.campus.eventmanager.repository.UserRepository;
import java.util.List;

import com.campus.eventmanager.dto.UserDTO;
import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.repository.RegistrationRepository;

// Developed BY Abhinay Srivastava 

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RegistrationRepository registrationRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/me")
    public User getMyProfile(Authentication authentication) {

        if(authentication == null){
            throw new RuntimeException("User not authenticated");
        }

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

@GetMapping("/me/registrations")
public List<Registration> getMyRegistrations(Authentication authentication) {

    String email = authentication.getName();

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    return registrationRepository.findByUser_Id(user.getId());
}

}
