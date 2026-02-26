package com.example.demojava.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String email;
    private String name;
    private String phone;
    private String password;
    private String taxId;
    private String createdAt;
    private List<Address> addresses;
}
