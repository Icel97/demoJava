package com.example.demojava.service;

import com.example.demojava.dto.UserCreateRequest;
import com.example.demojava.dto.UserPatchRequest;
import com.example.demojava.dto.UserResponse;
import com.example.demojava.model.Address;
import com.example.demojava.model.User;

import com.example.demojava.util.CryptoUtil;
import com.example.demojava.util.DateUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    private int addressSequence = 1;

    private int generateAddressId() {
        return addressSequence++;
    }

    @PostConstruct
    public void init() {
        users.add(new User(
                UUID.randomUUID(),
                "user1@gmail.com",
                "user1",
                "+15555555555",
                CryptoUtil.encrypt("123456"),
                "AARR990101XXX",
                DateUtil.nowMadagascar(),
                List.of(
                        new Address(1, "workaddress", "street No. 1", "UK"),
                        new Address(2, "homeaddress", "street No. 2", "AU")
                )
        ));
    }

    public List<UserResponse> getUsersSorted(String sortedBy) {
        List<User> sortedUsers = new ArrayList<>(users);

        if (sortedBy == null || sortedBy.isBlank()) {
            return sortedUsers.stream()
                    .map(UserResponse::from)
                    .toList();
        }

        Comparator<User> comparator = switch (sortedBy) {
            case "email" -> Comparator.comparing(User::getEmail);
            case "id" -> Comparator.comparing(User::getId);
            case "name" -> Comparator.comparing(User::getName);
            case "phone" -> Comparator.comparing(User::getPhone);
            case "tax_id" -> Comparator.comparing(User::getTaxId);
            case "created_at" -> Comparator.comparing(User::getCreatedAt);
            default -> throw new IllegalArgumentException("Invalid sortedBy parameter: " + sortedBy);
        };

        sortedUsers.sort(comparator);

        return sortedUsers.stream()
                .map(UserResponse::from)
                .toList();
    }

    private boolean applyFilter(User user, String field, String operator, String value) {

        String fieldValue = switch (field) {
            case "email" -> user.getEmail();
            case "id" -> user.getId().toString();
            case "name" -> user.getName();
            case "phone" -> user.getPhone();
            case "tax_id" -> user.getTaxId();
            case "created_at" -> user.getCreatedAt();
            default -> throw new IllegalArgumentException("Invalid filter field: " + field);
        };

        return switch (operator) {
            case "co" -> fieldValue.contains(value);
            case "eq" -> fieldValue.equals(value);
            case "sw" -> fieldValue.startsWith(value);
            case "ew" -> fieldValue.endsWith(value);
            default -> throw new IllegalArgumentException("Invalid filter operator: " + operator);
        };
    }

    public List<UserResponse> getUsersFiltered(String filter) {
        String[] parts = filter.split("\\+");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid filter format. Expected format: field+operator+value");
        }

        String field = parts[0];
        String operator = parts[1];
        String value = parts[2];

        return users.stream()
                .filter(user -> applyFilter(user, field, operator, value))
                .map(UserResponse::from)
                .toList();
    }

    public UserResponse createUser(UserCreateRequest request) {
        boolean taxIdExists = users.stream()
                .anyMatch(user -> user.getTaxId().equals(request.taxId()));

        if (taxIdExists) {
            throw new IllegalArgumentException("Tax ID already exists: " + request.taxId());
        }

        User user = new User(
                UUID.randomUUID(),
                request.email(),
                request.name(),
                request.phone(),
                CryptoUtil.encrypt(request.password()),
                request.taxId(),
                DateUtil.nowMadagascar(),
                request.addresses() == null
                        ? List.of()
                        : request.addresses().stream()
                                .map(addr -> new Address(
                                        generateAddressId(),
                                        addr.name(),
                                        addr.street(),
                                        addr.countryCode()
                                ))
                                .toList()
        );

        users.add(user);

        return UserResponse.from(user);
    }

    public UserResponse updateUser(String id, UserPatchRequest request) {

        UUID userId;
        try {
            userId = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID format");
        }

        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }

        if (request.getName() != null) {
            user.setName(request.getName());
        }

        if (request.getPhone() != null) {
            user.setPhone(request.getPhone());
        }

        if (request.getPassword() != null) {
            user.setPassword(CryptoUtil.encrypt(request.getPassword()));
        }

        if (request.getTaxId() != null) {
            boolean exists = users.stream()
                    .anyMatch(u ->
                            !u.getId().equals(userId) &&
                                    u.getTaxId().equals(request.getTaxId())
                    );

            if (exists) {
                throw new IllegalArgumentException("TaxId already exists");
            }

            user.setTaxId(request.getTaxId());
        }

        return UserResponse.from(user);
    }

    public void deleteUser(UUID id) {
        boolean removed = users.removeIf(user -> user.getId().equals(id));

        if (!removed) {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
