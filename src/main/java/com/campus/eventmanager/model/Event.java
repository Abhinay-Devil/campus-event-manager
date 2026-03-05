package com.campus.eventmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String location;

    private LocalDateTime eventDate;

    private Integer capacity;

    private Boolean registrationOpen;

    public boolean isRegistrationOpen() {
    return registrationOpen;
}

// Developed BY Abhinay Srivastava

}
