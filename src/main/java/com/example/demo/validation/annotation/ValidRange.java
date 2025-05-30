package com.example.demo.validation.annotation;

import com.example.demo.validation.validator.RangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = RangeValidator.class)
public @interface ValidRange {
    String message() default "To value must greater than from value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
