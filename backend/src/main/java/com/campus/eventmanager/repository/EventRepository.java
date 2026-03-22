package com.campus.eventmanager.repository;

import com.campus.eventmanager.model.Event;
// import com.campus.eventmanager.dto.EventStatsDTO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

    // Developed BY abhinay Srivastava 

@Query(value = """
SELECT * FROM event e
WHERE 
(:keyword IS NULL OR LOWER(e.title) LIKE CONCAT('%', :keyword, '%'))
AND (:location IS NULL OR LOWER(e.location) LIKE CONCAT('%', :location, '%'))
AND (:date IS NULL OR e.event_date >= :date AND e.event_date < :dateEnd)
""",
countQuery = """
SELECT count(*) FROM event e
WHERE 
(:keyword IS NULL OR LOWER(e.title) LIKE CONCAT('%', :keyword, '%'))
AND (:location IS NULL OR LOWER(e.location) LIKE CONCAT('%', :location, '%'))
AND (:date IS NULL OR e.event_date >= :date AND e.event_date < :dateEnd)
""",
nativeQuery = true)
Page<Event> searchAndFilterEvents(
        @Param("keyword") String keyword,
        @Param("location") String location,
        @Param("date") LocalDate date,
        @Param("dateEnd") LocalDate dateEnd,
        Pageable pageable
);

    @Query("SELECT COUNT(e) FROM Event e WHERE e.eventDate > CURRENT_TIMESTAMP")
    long countUpcomingEvents();

    @Query("SELECT COUNT(e) FROM Event e WHERE e.eventDate < CURRENT_TIMESTAMP")
    long countCompletedEvents();

    @Query("SELECT COUNT(e) FROM Event e WHERE e.registrationOpen = true AND e.eventDate >= CURRENT_TIMESTAMP")
    long countOngoingEvents();

    @Query("SELECT AVG(CAST((SELECT COUNT(r) FROM Registration r WHERE r.event.id = e.id) AS double)) FROM Event e")
    Double getAverageRegistrationsPerEvent();

    @Query("SELECT COALESCE(AVG(CAST((SELECT COUNT(r) FROM Registration r WHERE r.event.id = e.id) AS double) / NULLIF(e.capacity, 0)), 0) FROM Event e")
    Double getOverallCapacityUtilization();

    @Query("SELECT e.id, e.title, COUNT(r), e.capacity " +
           "FROM Event e LEFT JOIN e.registrations r " +
           "GROUP BY e.id, e.title, e.capacity " +
           "ORDER BY COUNT(r) DESC")
    List<Object[]> findPopularEventsRaw(Pageable pageable);
}
