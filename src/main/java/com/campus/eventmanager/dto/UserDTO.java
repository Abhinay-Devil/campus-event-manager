package com.campus.eventmanager.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private String role;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
}
