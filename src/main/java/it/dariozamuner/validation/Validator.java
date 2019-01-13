package it.dariozamuner.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import java.util.Set;

public class Validator {
    private javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public final void validate(final Object object) {
        final Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
        if (!constraintViolations.isEmpty()) {
            final StringBuilder stringBuilder = new StringBuilder();
            constraintViolations.iterator().forEachRemaining(
                    violation -> stringBuilder.append(String.format("'%s' with value '%s' %s | ",
                            violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage()))
            );
            throw new ValidationException(stringBuilder.toString());
        }
    }
}
