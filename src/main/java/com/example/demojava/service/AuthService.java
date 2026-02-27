package com.example.demojava.service;

import com.example.demojava.model.User;
import com.example.demojava.repository.UserRepository;
import com.example.demojava.util.CryptoUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public User authenticate(String taxId, String rawPassword) {

        User user = repository.getUsers().stream()
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
