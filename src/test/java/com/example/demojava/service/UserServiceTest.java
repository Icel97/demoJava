package com.example.demojava.service;

import com.example.demojava.dto.UserCreateRequest;
import com.example.demojava.dto.UserResponse;
import com.example.demojava.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    void shouldCreateUserSuccessfully() {

        UserCreateRequest request = new UserCreateRequest(
                "john@test.com",
                "John Doe",
                "5512345678",
                "password123",
                "DOEJ800101XXX",
                List.of()
        );

        UserResponse response = userService.createUser(request);

        assertNotNull(response);
        assertEquals("john@test.com", response.getEmail());
        assertEquals("John Doe", response.getName());
        assertEquals("DOEJ800101XXX", response.getTaxId());
    }

    @Test
    void shouldThrowExceptionWhenTaxIdAlreadyExists() {

        UserCreateRequest request = new UserCreateRequest(
                "john@test.com",
                "John Doe",
                "5512345678",
                "password123",
                "DOEJ800101XXX",
                List.of()
        );

        userService.createUser(request);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.createUser(request)
        );

        assertTrue(exception.getMessage().contains("Tax ID already exists"));
    }
}