package com.codegym.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeRangeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeRange {
    int min();
    int max();
    String message() default "The age between {min} and {max}";
    Class<?>[] group() default {};
    Class<? extends Payload>[] payload() default {};
}
