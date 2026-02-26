package com.example.demojava.dto;

import com.example.demojava.model.Address;
import com.example.demojava.model.User;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponse {

    private UUID id;
    private String email;
    private String name;
    private String phone;
    private String taxId;
    private String createdAt;
    private List<Address> addresses;

    public static UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setPhone(user.getPhone());
        response.setTaxId(user.getTaxId());
        response.setCreatedAt(user.getCreatedAt());
        response.setAddresses(user.getAddresses());
        return response;
    }
}
