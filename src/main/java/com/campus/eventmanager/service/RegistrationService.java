package com.campus.eventmanager.service;

import com.campus.eventmanager.model.Event;
import com.campus.eventmanager.model.Registration;
import com.campus.eventmanager.model.User;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.repository.RegistrationRepository;
import com.campus.eventmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public Registration register(Long eventId) {

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

        Registration registration = Registration.builder()
                .user(user)
                .event(event)
                .registeredAt(LocalDateTime.now())
                .build();

        return registrationRepository.save(registration);
    }

public void cancelRegistration(Long eventId, Long userId) {

    Registration registration = registrationRepository
            .findByUserIdAndEventId(userId, eventId)
            .orElseThrow(() -> new RuntimeException("Registration not found"));

    registrationRepository.delete(registration);
}

}