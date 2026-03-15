package com.campus.eventmanager.controller;

// import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.service.EventService;

import jakarta.validation.Valid;
import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.response.ApiResponse;

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
public ResponseEntity<ApiResponse<EventDTO>> createEvent(@Valid @RequestBody @NonNull EventDTO eventDTO) {
    EventDTO createdEvent = eventService.createEvent(eventDTO);
    return ResponseEntity.ok(ApiResponse.success("Event created successfully", createdEvent));
}

@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
public ResponseEntity<ApiResponse<Void>> deleteEvent(@PathVariable @NonNull Long id) {
    eventService.deleteEvent(id);
    return ResponseEntity.ok(ApiResponse.success("Event deleted successfully", null));
}

@GetMapping("/{id}")
public ResponseEntity<ApiResponse<EventDTO>> getEventById(@PathVariable @NonNull Long id){
    EventDTO event = eventService.getEventById(id);
    return ResponseEntity.ok(ApiResponse.success("Event retrieved successfully", event));
}

    @GetMapping
public ResponseEntity<ApiResponse<Page<EventDTO>>> getAllEvents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction
){
    Page<EventDTO> events = eventService.getAllEvents(page, size, sortBy, direction);
    return ResponseEntity.ok(ApiResponse.success("Events retrieved successfully", events));
}

@PutMapping("/{id}")
public ResponseEntity<ApiResponse<EventDTO>> updateEvent(@PathVariable @NonNull Long id, @RequestBody @NonNull EventDTO eventDTO){
    EventDTO updatedEvent = eventService.updateEvent(id,eventDTO);
    return ResponseEntity.ok(ApiResponse.success("Event updated successfully", updatedEvent));
}

}