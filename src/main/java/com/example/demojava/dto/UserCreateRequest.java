package com.example.demojava.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserCreateRequest (
        @Email
        @NotBlank
        String email,

        @NotBlank
        String name,

        @NotBlank
        String phone,

        @NotBlank
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password,

        @NotBlank
        @Pattern(
                regexp = "^[A-Z]{4}\\d{6}[A-Z0-9]{3}$",
                message = "Invalid taxId format"
        )
        String taxId,

        List<AddressRequest> addresses
) {}
