package com.campus.eventmanager.dto;

public class EventStatsDTO {
    private Long eventId;
    private String title;
    private long registrationCount;
    private int capacity;
    private double utilizationPercentage;

    public EventStatsDTO() {
    }

    public EventStatsDTO(Long eventId, String title, long registrationCount, int capacity, double utilizationPercentage) {
        this.eventId = eventId;
        this.title = title;
        this.registrationCount = registrationCount;
        this.capacity = capacity;
        this.utilizationPercentage = utilizationPercentage;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getRegistrationCount() {
        return registrationCount;
    }

    public void setRegistrationCount(long registrationCount) {
        this.registrationCount = registrationCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getUtilizationPercentage() {
        return utilizationPercentage;
    }

    public void setUtilizationPercentage(double utilizationPercentage) {
        this.utilizationPercentage = utilizationPercentage;
    }
}