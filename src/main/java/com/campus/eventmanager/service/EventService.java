package com.campus.eventmanager.service;

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

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

public Event getEventById(Long id) {
    return eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));
}

public Event updateEvent(Long id, Event updatedEvent) {

    Event event = eventRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found"));

    event.setTitle(updatedEvent.getTitle());
    event.setDescription(updatedEvent.getDescription());
    event.setLocation(updatedEvent.getLocation());
    event.setEventDate(updatedEvent.getEventDate());
    event.setCapacity(updatedEvent.getCapacity());

    return eventRepository.save(event);
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