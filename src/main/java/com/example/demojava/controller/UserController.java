package com.example.demojava.controller;

import com.example.demojava.dto.UserCreateRequest;
import com.example.demojava.dto.UserPatchRequest;
import com.example.demojava.dto.UserResponse;
import com.example.demojava.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getUsers(
            @RequestParam(required = false) String sortedBy,
            @RequestParam(required = false) String filter
    ) {
        if (filter != null && !filter.isBlank()) {
            return userService.getUsersFiltered(filter);
        }

        return userService.getUsersSorted(sortedBy);
    }

    @PostMapping
    @ResponseStatus
    public UserResponse createUser(
            @Valid @RequestBody UserCreateRequest request
    ) {
        return userService.createUser(request);
    }

    @PatchMapping
    public UserResponse updateUser(
            @PathVariable String id,
            @RequestBody UserPatchRequest request
    ) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
