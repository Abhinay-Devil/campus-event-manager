package com.campus.eventmanager.repository;

import com.campus.eventmanager.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

  boolean existsByUser_IdAndEvent_Id(Long userId, Long eventId);

  long countByEventId(Long eventId);
}
