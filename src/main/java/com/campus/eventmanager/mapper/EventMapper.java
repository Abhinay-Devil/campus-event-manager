package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDTO toDTO(Event event);

    Event toEntity(EventDTO dto);

}
