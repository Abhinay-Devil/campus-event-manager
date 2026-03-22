package com.campus.eventmanager.repository;

import com.campus.eventmanager.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    long countByEventId(Long eventId);

    boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId);

    Optional<Registration> findByUser_IdAndEvent_Id(Long userId, Long eventId);

    List<Registration> findByUser_Id(Long userId);

}