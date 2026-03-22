package com.campus.eventmanager.dto;

public class DashboardDTO {
    private long totalUsers;
    private long totalEvents;
    private long totalRegistrations;

    public DashboardDTO() {
    }

    public DashboardDTO(long totalUsers, long totalEvents, long totalRegistrations) {
        this.totalUsers = totalUsers;
        this.totalEvents = totalEvents;
        this.totalRegistrations = totalRegistrations;
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
}
