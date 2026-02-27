package com.example.demojava.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank
    @JsonProperty("tax_id")
    private String taxId;

    @NotBlank
    private String password;
}