package it.dariozamuner.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Custom validator for integer type.
 * It returns true only if the field is not null and not zero.
 */
public class NotZeroValidator implements ConstraintValidator<NotZeroValidator.NotZero, Integer> {

    @Override
    public void initialize(final NotZero constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Integer value, final ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value != 0;
    }

    @Target(FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = NotZeroValidator.class)
    @Documented
    public @interface NotZero {
        String message() default "";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
}
