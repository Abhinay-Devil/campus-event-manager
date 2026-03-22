package com.campus.eventmanager.service;

import com.campus.eventmanager.dto.AdminAnalyticsDTO;
import com.campus.eventmanager.dto.DashboardDTO;
import com.campus.eventmanager.dto.EventStatsDTO;
import com.campus.eventmanager.dto.UserGrowthDTO;
import com.campus.eventmanager.repository.EventRepository;
import com.campus.eventmanager.repository.RegistrationRepository;
import com.campus.eventmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final RegistrationRepository registrationRepository;

    public AdminService(UserRepository userRepository,
                        EventRepository eventRepository,
                        RegistrationRepository registrationRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.registrationRepository = registrationRepository;
    }

    public DashboardDTO getDashboardStats() {
        log.info("Fetching dashboard statistics");
        long totalUsers = userRepository.count();
        long totalEvents = eventRepository.count();
        long totalRegistrations = registrationRepository.count();
        log.debug("Dashboard stats: users={}, events={}, registrations={}", totalUsers, totalEvents, totalRegistrations);
        return new DashboardDTO(totalUsers, totalEvents, totalRegistrations);
    }

    public AdminAnalyticsDTO getAdvancedAnalytics() {
        log.info("Fetching advanced analytics");
        long totalUsers = userRepository.count();
        long totalEvents = eventRepository.count();
        long totalRegistrations = registrationRepository.count();

        long upcomingEvents = eventRepository.countUpcomingEvents();
        long completedEvents = eventRepository.countCompletedEvents();
        long ongoingEvents = eventRepository.countOngoingEvents();

        List<EventStatsDTO> popularEvents = eventRepository.findPopularEventsRaw(PageRequest.of(0, 10))
            .stream()
            .map(row -> {
                Long eventId = (Long) row[0];
                String title = (String) row[1];
                Long count = (Long) row[2];
                Integer capacity = (Integer) row[3];
                double utilization = capacity != null && capacity > 0 ? (count * 100.0 / capacity) : 0.0;
                return new EventStatsDTO(eventId, title, count, capacity != null ? capacity : 0, utilization);
            })
            .collect(Collectors.toList());

        List<UserGrowthDTO> userGrowth = userRepository.getUserGrowthByMonth();

        Double avgRegistrations = eventRepository.getAverageRegistrationsPerEvent();
        double averageRegistrationsPerEvent = avgRegistrations != null ? avgRegistrations : 0.0;

        Double utilization = eventRepository.getOverallCapacityUtilization();
        double overallCapacityUtilization = utilization != null ? utilization : 0.0;

        log.debug("Analytics calculated: totalUsers={}, popularEventsSize={}", totalUsers, popularEvents.size());
        return new AdminAnalyticsDTO(
            totalUsers, totalEvents, totalRegistrations,
            upcomingEvents, ongoingEvents, completedEvents,
            popularEvents, userGrowth,
            averageRegistrationsPerEvent, overallCapacityUtilization
        );
    }
}