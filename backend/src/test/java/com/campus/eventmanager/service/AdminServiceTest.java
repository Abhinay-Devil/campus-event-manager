package com.campus.eventmanager.service;

import com.campus.eventmanager.dto.AdminAnalyticsDTO;
import com.campus.eventmanager.dto.DashboardDTO;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.repository.RegistrationRepository;
import com.campus.eventmanager.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AdminServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private RegistrationRepository registrationRepository;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDashboardStats() {
        // Arrange
        when(userRepository.count()).thenReturn(10L);
        when(eventRepository.count()).thenReturn(5L);
        when(registrationRepository.count()).thenReturn(20L);

        // Act
        DashboardDTO result = adminService.getDashboardStats();

        // Assert
        assertEquals(10L, result.getTotalUsers());
        assertEquals(5L, result.getTotalEvents());
        assertEquals(20L, result.getTotalRegistrations());
    }

    @Test
    void testGetAdvancedAnalytics() {
        // Arrange
        when(userRepository.count()).thenReturn(10L);
        when(eventRepository.count()).thenReturn(5L);
        when(registrationRepository.count()).thenReturn(20L);
        when(eventRepository.countUpcomingEvents()).thenReturn(3L);
        when(eventRepository.countCompletedEvents()).thenReturn(1L);
        when(eventRepository.countOngoingEvents()).thenReturn(1L);
        when(eventRepository.findPopularEventsRaw(any(PageRequest.class))).thenReturn(List.of());
        when(userRepository.getUserGrowthByMonth()).thenReturn(List.of());
        when(eventRepository.getAverageRegistrationsPerEvent()).thenReturn(4.0);
        when(eventRepository.getOverallCapacityUtilization()).thenReturn(80.0);

        // Act
        AdminAnalyticsDTO result = adminService.getAdvancedAnalytics();

        // Assert
        assertEquals(10L, result.getTotalUsers());
        assertEquals(5L, result.getTotalEvents());
        assertEquals(20L, result.getTotalRegistrations());
        assertEquals(3L, result.getUpcomingEvents());
        assertEquals(1L, result.getCompletedEvents());
        assertEquals(1L, result.getOngoingEvents());
        assertEquals(4.0, result.getAverageRegistrationsPerEvent());
        assertEquals(80.0, result.getOverallCapacityUtilization());
    }
}