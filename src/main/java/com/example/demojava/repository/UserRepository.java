package com.example.demojava.repository;

import com.example.demojava.model.Address;
import com.example.demojava.model.User;
import com.example.demojava.util.CryptoUtil;
import com.example.demojava.util.DateUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(
                UUID.randomUUID(),
                "alice.johnson@mail.com",
                "Alice Johnson",
                "+15551234567",
                CryptoUtil.encrypt("Password123"),
                "JOHA900101ABC",
                DateUtil.nowMadagascar(),
                List.of(
                        new Address(1, "workaddress", "221B Baker Street", "UK"),
                        new Address(2, "homeaddress", "742 Evergreen Terrace", "US")
                )
        ));

        users.add(new User(
                UUID.randomUUID(),
                "carla.lopez@mail.com",
                "Carla Lopez",
                "+34911222333",
                CryptoUtil.encrypt("Admin789"),
                "LOPC920202GHI",
                DateUtil.nowMadagascar(),
                List.of(
                        new Address(4, "branch", "Gran Via 45", "ES"),
                        new Address(5, "summerhouse", "Calle Luna 77", "ES")
                )
        ));

        users.add(new User(
                UUID.randomUUID(),
                "bruno.smith@example.com",
                "Bruno Smith",
                "+525512345678",
                CryptoUtil.encrypt("Secure456"),
                "SMIB850505DEF",
                DateUtil.nowMadagascar(),
                List.of(
                        new Address(3, "mainoffice", "Av. Reforma 123", "MX")
                )
        ));
    }
    public List<User> getUsers() {
        return users;
    }
}
