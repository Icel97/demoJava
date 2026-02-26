package com.example.demojava.controller;

import com.example.demojava.dto.LoginRequest;
import com.example.demojava.dto.LoginResponse;
import com.example.demojava.dto.UserResponse;
import com.example.demojava.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        var user = userService.authenticate(
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