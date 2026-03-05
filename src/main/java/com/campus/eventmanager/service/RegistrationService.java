package com.campus.eventmanager.service;

import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.model.User;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.repository.RegistrationRepository;
import com.campus.eventmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

   public Registration registerUser(Long userId, Long eventId) {

    if (registrationRepository.existsByUser_IdAndEvent_Id(userId, eventId)) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "User already registered for this event");
    }

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found"));

    Event event = eventRepository.findById(eventId)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Event not found"));

    if (!event.isRegistrationOpen()) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Registration is closed for this event");
    }
long registeredCount = registrationRepository.countByEventId(eventId);

    if (event.getCapacity() != null && registeredCount >= event.getCapacity()) {
        throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Event capacity full");
    }

    Registration registration = Registration.builder()
            .user(user)
            .event(event)
            .registeredAt(LocalDateTime.now())
            .build();

    return registrationRepository.save(registration);
}
}