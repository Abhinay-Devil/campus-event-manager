package com.campus.eventmanager.service;

import com.campus.eventmanager.dto.EventDTO;
import com.campus.eventmanager.mapper.EventMapper;
import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.repository.EventRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    // Create Event
    public EventDTO createEvent(EventDTO dto) {

        log.info("Creating event: {}", dto.getTitle());

        Event event = EventMapper.toEntity(dto);
        Event savedEvent = eventRepository.save(event);

        return EventMapper.toDTO(savedEvent);
    }

    // Get Event by ID
    public EventDTO getEventById(Long id) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        return EventMapper.toDTO(event);
    }

    // Update Event
    public EventDTO updateEvent(Long id, EventDTO dto) {

        log.info("Updating event with id: {}", id);

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

    // Delete Event
    public void deleteEvent(Long id) {

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

        return eventsPage.map(EventMapper::toDTO);
    }
}