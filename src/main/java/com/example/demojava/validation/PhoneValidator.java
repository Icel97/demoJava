package com.example.demojava.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        String normalized = value.replaceAll("[\\s-]", "");

        return normalized.matches("^\\+?\\d{11,13}$");
    }
}