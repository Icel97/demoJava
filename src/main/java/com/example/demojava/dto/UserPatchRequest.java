package com.example.demojava.dto;

import com.example.demojava.validation.Phone;
import com.example.demojava.validation.RFC;
import jakarta.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPatchRequest {

    @Email(message = "Invalid email format")
    private String email;

    private String name;

    @Phone
    private String phone;

    private String password;

    @RFC
    private String taxId;
}