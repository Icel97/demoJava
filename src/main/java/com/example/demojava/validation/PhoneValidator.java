package com.example.demojava.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String PHONE_REGEX =
            "^\\+?\\d{1,3}[\\s-]?\\d{10}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;

        String normalized = value.replaceAll("[\\s-]", "");

        return normalized.matches("^\\+?\\d{11,13}$");
    }
}