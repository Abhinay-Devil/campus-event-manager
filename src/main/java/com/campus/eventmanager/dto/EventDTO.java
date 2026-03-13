package com.campus.eventmanager.dto;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;

public class EventDTO {

    private Long id;   

   @NotBlank(message = "Event title is required")
private String title;

@NotBlank(message = "Description is required")
private String description;

@NotNull(message = "Event date is required")
private LocalDateTime eventDate;

@NotNull(message = "Capacity is required")
private Integer capacity;

private String location; 


    public EventDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
    return capacity;
}

public void setCapacity(int capacity) {
    this.capacity = capacity;
}
}
