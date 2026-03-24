package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.UserDTO;
import com.campus.eventmanager.model.Role;
import com.campus.eventmanager.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = Role.class)
public interface UserMapper {

    @Mapping(target = "role", expression = "java(user.getRole().name())")
    UserDTO toDTO(User user);

    @Mapping(target = "role", expression = "java(Role.valueOf(dto.getRole()))")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    User toEntity(UserDTO dto);

}