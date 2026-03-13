package com.campus.eventmanager.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.dto.UserDTO;
import com.campus.eventmanager.exception.EmailAlreadyExistsException;
import com.campus.eventmanager.mapper.UserMapper;
import com.campus.eventmanager.model.User;
import java.util.List;
// import com.campus.eventmanager.model.Role;
// import org.springframework.stereotype.Service;


// Developed BY Abhinay Srivastava 

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {

    List<User> users = userRepository.findAll();

    return users.stream()
            .map(UserMapper::toDTO)
            .toList();
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

    public UserDTO register(UserDTO userDTO) {

        User user = UserMapper.toEntity(userDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return UserMapper.toDTO(user);
    }

}
