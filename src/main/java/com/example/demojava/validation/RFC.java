package com.example.demojava.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RFCValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RFC {

    String message() default "tax_id must follow RFC format: AAAA######XXX";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}