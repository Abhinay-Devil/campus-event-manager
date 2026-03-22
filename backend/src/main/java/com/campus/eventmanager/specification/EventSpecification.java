package com.campus.eventmanager.specification;

import com.campus.eventmanager.model.Event;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class EventSpecification {

    public static Specification<Event> search(
            String keyword,
            String location,
            LocalDate date,
            Integer minCapacity,
            Integer maxCapacity,
            Boolean registrationOpen,
            String status // "upcoming", "ongoing", "completed"
    ) {
        return (root, query, cb) -> {

            var predicates = cb.conjunction();

            if (keyword != null) {
                predicates = cb.and(predicates,
                        cb.like(cb.lower(root.get("title")), "%" + keyword.toLowerCase() + "%"));
            }

            if (location != null) {
                predicates = cb.and(predicates,
                        cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%"));
            }

            if (date != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("eventDate").as(LocalDate.class), date));
            }

            if (minCapacity != null) {
                predicates = cb.and(predicates,
                        cb.greaterThanOrEqualTo(root.get("capacity"), minCapacity));
            }

            if (maxCapacity != null) {
                predicates = cb.and(predicates,
                        cb.lessThanOrEqualTo(root.get("capacity"), maxCapacity));
            }

            if (registrationOpen != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("registrationOpen"), registrationOpen));
            }

            if (status != null) {
                switch (status.toLowerCase()) {
                    case "upcoming":
                        predicates = cb.and(predicates,
                                cb.greaterThan(root.get("eventDate"), cb.currentTimestamp()));
                        break;
                    case "completed":
                        predicates = cb.and(predicates,
                                cb.lessThan(root.get("eventDate"), cb.currentTimestamp()));
                        break;
                    case "ongoing":
                        predicates = cb.and(predicates,
                                cb.equal(root.get("registrationOpen"), true),
                                cb.greaterThanOrEqualTo(root.get("eventDate"), cb.currentTimestamp()));
                        break;
                }
            }

            return predicates;
        };
    }

    // Developed BY Abhinay Srivastava
}
