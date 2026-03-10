package com.campus.eventmanager.controller;

import com.campus.eventmanager.security.CustomUserDetailsService;
import com.campus.eventmanager.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.campus.eventmanager.model.AuthRequest;
// import org.springframework.security.core.userdetails.UserDetails;

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
public String login(@RequestBody AuthRequest request) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );

    UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

    return jwtUtil.generateToken(userDetails);
}
}