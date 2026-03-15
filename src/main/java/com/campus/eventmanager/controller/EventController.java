package com.campus.eventmanager.controller;

// import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.service.EventService;

import jakarta.validation.Valid;
import com.campus.eventmanager.dto.EventDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;

// import java.util.List;
import org.springframework.lang.NonNull;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
@PreAuthorize("hasAnyRole('ADMIN','FACULTY')")
public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody @NonNull EventDTO eventDTO) {
    return ResponseEntity.ok(eventService.createEvent(eventDTO));
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public String deleteEvent(@PathVariable @NonNull Long id) {
    eventService.deleteEvent(id);
    return "Event deleted successfully";
}

@GetMapping("/{id}")
public EventDTO getEventById(@PathVariable @NonNull Long id){
    return eventService.getEventById(id);
}

    @GetMapping
public Page<EventDTO> getAllEvents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
){
    return eventService.getAllEvents(page, size, sortBy, direction);
}

@PutMapping("/{id}")
public EventDTO updateEvent(@PathVariable @NonNull Long id, @RequestBody @NonNull EventDTO eventDTO){
    return eventService.updateEvent(id,eventDTO);
}

}