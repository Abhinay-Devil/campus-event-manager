package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.UserDTO;
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

}