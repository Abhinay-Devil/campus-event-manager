package com.campus.eventmanager.controller;

import com.campus.eventmanager.security.CustomUserDetailsService;
import com.campus.eventmanager.security.JwtUtil;
import com.campus.eventmanager.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.campus.eventmanager.dto.UserDTO;
import com.campus.eventmanager.model.AuthRequest;
// import org.springframework.security.core.userdetails.UserDetails;
// import com.campus.eventmanager.service.UserService;
import com.campus.eventmanager.response.ApiResponse;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
public ResponseEntity<ApiResponse<String>> login(@RequestBody AuthRequest request) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

    String token = jwtUtil.generateToken(userDetails);
    return ResponseEntity.ok(ApiResponse.success("Login successful", token));
}

@Autowired
    private UserService userService;

  @PostMapping("/register")
   public ResponseEntity<ApiResponse<UserDTO>> register(@Valid @RequestBody UserDTO userDTO) {
    UserDTO registeredUser = userService.register(userDTO);
    return ResponseEntity.ok(ApiResponse.success("User registered successfully", registeredUser));
}


}