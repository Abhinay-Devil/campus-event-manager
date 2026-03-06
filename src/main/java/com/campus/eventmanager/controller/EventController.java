package com.campus.eventmanager.controller;

import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.service.EventService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Develpoed BY Abhinay Srivastava 
@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

  @PostMapping
@PreAuthorize("hasAnyRole('ADMIN','FACULTY')")
public Event createEvent(@RequestBody Event event){
    return eventService.createEvent(event);
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public void deleteEvent(@PathVariable Long id){
    eventService.deleteEvent(id);
}



    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}