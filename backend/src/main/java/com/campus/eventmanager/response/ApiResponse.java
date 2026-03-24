package com.campus.eventmanager.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private List<String> errors;
    private LocalDateTime timestamp;

    public ApiResponse() {
    }

    public ApiResponse(String status, String message, T data, List<String> errors, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

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