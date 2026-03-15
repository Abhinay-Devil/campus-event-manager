package com.campus.eventmanager.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private List<String> errors;
    private LocalDateTime timestamp;

    // Success response constructor
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("success", message, data, null, LocalDateTime.now());
    }

    // Error response constructor
    public static ApiResponse<Void> error(String message, List<String> errors) {
        return new ApiResponse<>("error", message, null, errors, LocalDateTime.now());
    }

    // Error response constructor with single error
    public static ApiResponse<Void> error(String message, String error) {
        return new ApiResponse<>("error", message, null, Arrays.asList(error), LocalDateTime.now());
    }

    // Error response constructor without errors list
    public static ApiResponse<Void> error(String message) {
        return new ApiResponse<>("error", message, null, null, LocalDateTime.now());
    }
}