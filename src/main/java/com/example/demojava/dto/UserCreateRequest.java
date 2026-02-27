package com.example.demojava.dto;

import com.example.demojava.validation.Phone;
import com.example.demojava.validation.RFC;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserCreateRequest (
        @Email
        @NotBlank
        String email,

        @NotBlank
        String name,

        @NotBlank
        @Phone
        String phone,

        @NotBlank
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password,

        @NotBlank
        @JsonProperty("tax_id")
        @RFC
        String taxId,

        List<AddressRequest> addresses
) {}
