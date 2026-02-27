package com.example.demojava.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private  static  final String PHONE_REGEX =
            "^\\+?\\d{10,15}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        return value.matches(PHONE_REGEX);
    }
}