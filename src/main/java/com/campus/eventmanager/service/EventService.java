package com.campus.eventmanager.service;

import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
// Developed BY Abhinay Srivastava 
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

public void deleteEvent(Long id){
    eventRepository.deleteById(id);
}

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

}