package com.campus.eventmanager.dto;

public class UserGrowthDTO {
    private String period; // e.g., "2023-10"
    private long newUsers;

    public UserGrowthDTO() {
    }

    public UserGrowthDTO(String period, long newUsers) {
        this.period = period;
        this.newUsers = newUsers;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public long getNewUsers() {
        return newUsers;
    }

    public void setNewUsers(long newUsers) {
        this.newUsers = newUsers;
    }
}