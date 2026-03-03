package com.campus.eventmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.exception.EmailAlreadyExistsException;
import com.campus.eventmanager.model.User;

import java.time.LocalDateTime;
import java.util.List;
// Developed BY Abhinay Srivastava 

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

   public User createUser(User user) {

   if (userRepository.findByEmail(user.getEmail()).isPresent()) {
    throw new EmailAlreadyExistsException("Email already exists!");
}

    user.setCreatedAt(LocalDateTime.now());
    return userRepository.save(user);
}

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}