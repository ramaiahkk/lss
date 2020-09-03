package com.takoit.utils.lss.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {LCSRequestValidator.class})
@Documented
public @interface ValidateLCS {
    String message() default "REquest set of stings should be unique with no empty strings.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
