package com.example.demo.validation.validator;

import com.example.demo.dto.RangeDto;
import com.example.demo.validation.annotation.ValidRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, RangeDto> {
    @Override
    public boolean isValid(RangeDto value, ConstraintValidatorContext context) {
        return value.getFrom() < value.getTo();
    }
}
