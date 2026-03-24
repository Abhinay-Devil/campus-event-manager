package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO toDTO(Event event);

    @Mapping(target = "registrations", ignore = true)
    Event toEntity(EventDTO dto);

}
