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
public String deleteEvent(@PathVariable Long id) {
    eventService.deleteEvent(id);
    return "Event deleted successfully";
}

@GetMapping("/{id}")
public Event getEventById(@PathVariable Long id) {
    return eventService.getEventById(id);
}

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

@PutMapping("/{id}")
public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
    return eventService.updateEvent(id, event);
}

}