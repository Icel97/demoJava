package com.example.demojava.service;

import com.example.demojava.model.User;
import com.example.demojava.util.CryptoUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    private final List<User> users = new ArrayList<>();

    public User authenticate(String taxId, String rawPassword) {

        User user = users.stream()
                .filter(u -> u.getTaxId().equals(taxId))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid credentials")
                );

        String encryptedPassword = CryptoUtil.encrypt(rawPassword);

        if (!user.getPassword().equals(encryptedPassword)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return user;
    }
}
