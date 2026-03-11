package com.campus.eventmanager.mapper;

import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.model.Event;

public class EventMapper {

    public static EventDTO toDTO(Event event) {

        EventDTO dto = new EventDTO();

        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setEventDate(event.getEventDate());
        dto.setLocation(event.getLocation());

        return dto;
    }

    public static Event toEntity(EventDTO dto) {

        Event event = new Event();

        event.setId(dto.getId());
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setEventDate(dto.getEventDate());
        event.setLocation(dto.getLocation());

        return event;
    }
}
