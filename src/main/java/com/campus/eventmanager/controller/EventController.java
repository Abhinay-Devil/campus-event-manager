package com.campus.eventmanager.controller;

// import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.service.EventService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.campus.eventmanager.dto.EventDTO;

import org.springframework.http.ResponseEntity;
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
public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO) {
    return ResponseEntity.ok(eventService.createEvent(eventDTO));
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public String deleteEvent(@PathVariable Long id) {
    eventService.deleteEvent(id);
    return "Event deleted successfully";
}

@GetMapping("/{id}")
public EventDTO getEventById(@PathVariable Long id){
    return eventService.getEventById(id);
}

    @GetMapping
public List<EventDTO> getAllEvents(){
    return eventService.getAllEvents();
}

@PutMapping("/{id}")
public EventDTO updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO){
    return eventService.updateEvent(id,eventDTO);
}

}