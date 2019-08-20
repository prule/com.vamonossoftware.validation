package com.vamonossoftware.validation;

import java.util.Arrays;
import java.util.List;

public class FailFastValidator<T> implements Validator<T> {

    Validator<T> validator;

    public FailFastValidator(Validator<T> validator) {
        this.validator = validator;
    }

    public ValidationResults validate(T object) throws ValidationException {
        final ValidationResults validate = validator.validate(object);
        if (validate.isFailure()) {
            throw new ValidationException();
        }
        return validate;
    }

    @Override
    public ValidationResults getResults() {
        return validator.getResults();
    }
}
