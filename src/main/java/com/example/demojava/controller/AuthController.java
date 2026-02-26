package com.example.demojava.controller;

import com.example.demojava.dto.LoginRequest;
import com.example.demojava.dto.LoginResponse;
import com.example.demojava.dto.UserResponse;
import com.example.demojava.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        var user = authService.authenticate(
                request.getTaxId(),
                request.getPassword()
        );

        return ResponseEntity.ok(
                new LoginResponse(
                        "Login successful",
                        UserResponse.from(user)
                )
        );
    }
}