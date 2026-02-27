package com.example.demojava.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ApiError {

    private int status;
    private String error;
    private String message;
    private String timestamp;
    private List<String> details;

    public ApiError(int status, String error, String message, List<String> details) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
        this.details = details;
    }
}
