package com.campus.eventmanager.service;

import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.mapper.EventMapper;
import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.List;
// Developed BY Abhinay Srivastava 
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public EventDTO createEvent(EventDTO dto){

    Event event = EventMapper.toEntity(dto);

    Event saved = eventRepository.save(event);

    return EventMapper.toDTO(saved);
}

   public List<EventDTO> getAllEvents(){

    List<Event> events = eventRepository.findAll();

    return events.stream()
            .map(EventMapper::toDTO)
            .toList();
}

public EventDTO getEventById(Long id){

    Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));

    return EventMapper.toDTO(event);
}

public EventDTO updateEvent(Long id, EventDTO dto){

    Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));

    event.setTitle(dto.getTitle());
    event.setDescription(dto.getDescription());
    event.setLocation(dto.getLocation());
    event.setEventDate(dto.getEventDate());
    event.setCapacity(dto.getCapacity());

    Event updatedEvent = eventRepository.save(event);

    return EventMapper.toDTO(updatedEvent);
}

public void deleteEvent(Long id) {

    Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));

    eventRepository.delete(event);
}

public Page<Event> getEvents(int page, int size, String sortBy) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

    return eventRepository.findAll(pageable);
}

}