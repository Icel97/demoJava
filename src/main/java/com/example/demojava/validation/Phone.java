package com.example.demojava.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

    String message() default "Phone must be 10-15 digits and may include country code";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}