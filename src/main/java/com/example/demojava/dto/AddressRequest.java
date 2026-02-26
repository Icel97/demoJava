package com.example.demojava.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(

        @NotBlank
        String name,

        @NotBlank
        String street,

        @NotBlank
        String countryCode
) {
}
