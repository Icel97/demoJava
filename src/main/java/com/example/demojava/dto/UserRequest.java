package com.example.demojava.dto;

import com.example.demojava.validation.Phone;
import com.example.demojava.validation.RFC;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @Phone
    private String phone;

    @NotBlank
    private String password;

    @RFC
    private String taxId;
}
