package com.campus.eventmanager.service;

import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.mapper.EventMapper;
import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.specification.EventSpecification;

import org.springframework.lang.NonNull;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    // Create Event
    @SuppressWarnings("null")
    public EventDTO createEvent(@NonNull EventDTO dto) {

        log.info("Creating event: {}", dto.getTitle());

        Event event = eventMapper.toEntity(dto);
        Event savedEvent = eventRepository.save(event);

        return eventMapper.toDTO(savedEvent);
    }

    // Get Event by ID
    public EventDTO getEventById(@NonNull Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return eventMapper.toDTO(event);
    }

    // Update Event
    public EventDTO updateEvent(@NonNull Long id, @NonNull EventDTO dto) {

        log.info("Updating event with id: {}", id);

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setLocation(dto.getLocation());
        event.setEventDate(dto.getEventDate());
        event.setCapacity(dto.getCapacity());

        Event updatedEvent = eventRepository.save(event);

        return eventMapper.toDTO(updatedEvent);
    }

    // Delete Event
    @SuppressWarnings("null")
    public void deleteEvent(@NonNull Long id) {

        log.info("Deleting event with id: {}", id);

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        eventRepository.delete(event);
    }

    // Get All Events with Pagination + Sorting
    public Page<EventDTO> getAllEvents(int page, int size, String sortBy, String direction) {

        log.info("Fetching events page={}, size={}, sortBy={}, direction={}",
                page, size, sortBy, direction);

        Sort sort = "desc".equalsIgnoreCase(direction)
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Event> eventsPage = eventRepository.findAll(pageable);

        return eventsPage.map(eventMapper::toDTO);
    }

   public Page<EventDTO> searchEvents(
        String keyword,
        String location,
        LocalDate date,
        Integer minCapacity,
        Integer maxCapacity,
        Boolean registrationOpen,
        String status,
        int page,
        int size,
        String sortBy,
        String direction
) {

    keyword = (keyword == null || keyword.isBlank()) ? null : keyword;
    location = (location == null || location.isBlank()) ? null : location;

    Sort sort = "desc".equalsIgnoreCase(direction)
            ? Sort.by(sortBy).descending()
            : Sort.by(sortBy).ascending();

    Pageable pageable = PageRequest.of(page, size, sort);

    Page<Event> events = eventRepository.findAll(
            EventSpecification.search(keyword, location, date, minCapacity, maxCapacity, registrationOpen, status),
            pageable
    );

    return events.map(eventMapper::toDTO);
}


}