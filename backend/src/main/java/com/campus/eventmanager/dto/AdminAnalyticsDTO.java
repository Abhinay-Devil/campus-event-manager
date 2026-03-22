package com.campus.eventmanager.dto;

import java.util.List;

public class AdminAnalyticsDTO {

    private long totalUsers;
    private long totalEvents;
    private long totalRegistrations;

    // Event status distribution
    private long upcomingEvents;
    private long ongoingEvents;
    private long completedEvents;

    // Popular events
    private List<EventStatsDTO> popularEvents;

    // User growth over time
    private List<UserGrowthDTO> userGrowth;

    // Average registrations per event
    private double averageRegistrationsPerEvent;

    // Capacity utilization
    private double overallCapacityUtilization;

    public AdminAnalyticsDTO() {
    }

    public AdminAnalyticsDTO(long totalUsers, long totalEvents, long totalRegistrations,
                             long upcomingEvents, long ongoingEvents, long completedEvents,
                             List<EventStatsDTO> popularEvents, List<UserGrowthDTO> userGrowth,
                             double averageRegistrationsPerEvent, double overallCapacityUtilization) {
        this.totalUsers = totalUsers;
        this.totalEvents = totalEvents;
        this.totalRegistrations = totalRegistrations;
        this.upcomingEvents = upcomingEvents;
        this.ongoingEvents = ongoingEvents;
        this.completedEvents = completedEvents;
        this.popularEvents = popularEvents;
        this.userGrowth = userGrowth;
        this.averageRegistrationsPerEvent = averageRegistrationsPerEvent;
        this.overallCapacityUtilization = overallCapacityUtilization;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalEvents() {
        return totalEvents;
    }

    public void setTotalEvents(long totalEvents) {
        this.totalEvents = totalEvents;
    }

    public long getTotalRegistrations() {
        return totalRegistrations;
    }

    public void setTotalRegistrations(long totalRegistrations) {
        this.totalRegistrations = totalRegistrations;
    }

    public long getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(long upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public long getOngoingEvents() {
        return ongoingEvents;
    }

    public void setOngoingEvents(long ongoingEvents) {
        this.ongoingEvents = ongoingEvents;
    }

    public long getCompletedEvents() {
        return completedEvents;
    }

    public void setCompletedEvents(long completedEvents) {
        this.completedEvents = completedEvents;
    }

    public List<EventStatsDTO> getPopularEvents() {
        return popularEvents;
    }

    public void setPopularEvents(List<EventStatsDTO> popularEvents) {
        this.popularEvents = popularEvents;
    }

    public List<UserGrowthDTO> getUserGrowth() {
        return userGrowth;
    }

    public void setUserGrowth(List<UserGrowthDTO> userGrowth) {
        this.userGrowth = userGrowth;
    }

    public double getAverageRegistrationsPerEvent() {
        return averageRegistrationsPerEvent;
    }

    public void setAverageRegistrationsPerEvent(double averageRegistrationsPerEvent) {
        this.averageRegistrationsPerEvent = averageRegistrationsPerEvent;
    }

    public double getOverallCapacityUtilization() {
        return overallCapacityUtilization;
    }

    public void setOverallCapacityUtilization(double overallCapacityUtilization) {
        this.overallCapacityUtilization = overallCapacityUtilization;
    }
}
