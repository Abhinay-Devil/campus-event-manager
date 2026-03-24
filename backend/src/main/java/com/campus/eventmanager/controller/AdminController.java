package com.campus.eventmanager.controller;

import com.campus.eventmanager.response.ApiResponse;
import com.campus.eventmanager.service.AdminService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    // @GetMapping("/stats")
    // public ResponseEntity<ApiResponse<Map<String, Long>>> getStats() {

    //     Map<String, Long> stats = new HashMap<>();

    //     stats.put("users", userRepository.count());
    //     stats.put("events", eventRepository.count());
    //     stats.put("registrations", registrationRepository.count());

    //     return ResponseEntity.ok(ApiResponse.success("Statistics retrieved successfully", stats));
    // }

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
    this.adminService = adminService;
}

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<?>> getDashboardStats() {
        var dashboardStats = adminService.getDashboardStats();
        return ResponseEntity.ok(ApiResponse.success("Dashboard stats retrieved successfully", dashboardStats));
    }

    @GetMapping("/analytics")
    public ResponseEntity<ApiResponse<?>> getAdvancedAnalytics() {
        var analytics = adminService.getAdvancedAnalytics();
        return ResponseEntity.ok(ApiResponse.success("Advanced analytics retrieved successfully", analytics));
    }
}
