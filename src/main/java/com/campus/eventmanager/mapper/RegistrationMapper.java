package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.RegistrationDTO;
import com.campus.eventmanager.model.Registration;

public class RegistrationMapper {

    public static RegistrationDTO toDTO(Registration registration) {

        RegistrationDTO dto = new RegistrationDTO();

        dto.setId(registration.getId());
        dto.setUserId(registration.getUser().getId());
        dto.setEventId(registration.getEvent().getId());

        return dto;
    }

}
