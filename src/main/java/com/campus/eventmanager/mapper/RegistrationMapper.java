package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.RegistrationDTO;
import com.campus.eventmanager.model.Registration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "eventId", source = "event.id")
    RegistrationDTO toDTO(Registration registration);

}
