package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.UserDTO;
import com.campus.eventmanager.model.Role;
import com.campus.eventmanager.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());

        return dto;
    }

    public static User toEntity(UserDTO dto) {

        User user = new User();

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(Role.valueOf(dto.getRole()));

        return user;
    }
}