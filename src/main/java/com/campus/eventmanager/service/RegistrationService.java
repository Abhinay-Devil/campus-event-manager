package com.campus.eventmanager.service;

import com.campus.eventmanager.dto.RegistrationDTO;
import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.model.User;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.repository.RegistrationRepository;
import com.campus.eventmanager.repository.UserRepository;
import com.campus.eventmanager.mapper.RegistrationMapper;

import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final RegistrationMapper registrationMapper;

    public RegistrationService(RegistrationRepository registrationRepository, UserRepository userRepository, EventRepository eventRepository, RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.registrationMapper = registrationMapper;
    }

    // Register for event
    public RegistrationDTO register(@NonNull Long eventId) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (!event.isRegistrationOpen()) {
            throw new RuntimeException("Registration closed");
        }

        long count = registrationRepository.countByEventId(eventId);

        if (event.getCapacity() != null && count >= event.getCapacity()) {
            throw new RuntimeException("Event full");
        }

        if (registrationRepository.existsByUser_IdAndEvent_Id(user.getId(), eventId)) {
            throw new RuntimeException("Already registered");
        }

        Registration registration = new Registration();
        registration.setUser(user);
        registration.setEvent(event);
        registration.setRegisteredAt(LocalDateTime.now());

        Registration saved = registrationRepository.save(registration);

        return registrationMapper.toDTO(saved);
    }

    // Cancel registration
    public void cancelRegistration(@NonNull Long eventId, @NonNull Long userId) {

        Registration registration = registrationRepository
                .findByUser_IdAndEvent_Id(userId, eventId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        registrationRepository.delete(registration);
    }
}