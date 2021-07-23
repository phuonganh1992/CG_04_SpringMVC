package com.codegym.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeRangeConstraintValidator implements ConstraintValidator<AgeRange, LocalDate>{
    private AgeRange annotation;

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(value==null) return true;
        int year=LocalDate.now().getYear()- value.getYear();
        return year>=annotation.min() && year<=annotation.max();
    }

    @Override
    public void initialize(AgeRange constraintAnnotation) {
        this.annotation=constraintAnnotation;
    }
}
