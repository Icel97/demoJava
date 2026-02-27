package com.example.demojava.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RFCValidator implements ConstraintValidator<RFC, String> {

    private static final String RFC_REGEX =
            "^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return value.matches(RFC_REGEX);
    }
}