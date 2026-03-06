package com.campus.eventmanager.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.exception.EmailAlreadyExistsException;
import com.campus.eventmanager.model.User;
import java.util.List;


// Developed BY Abhinay Srivastava 

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }

public User getUserByEmail(String email) {
    return userRepository.findByEmail(email).orElseThrow();
}
    
}