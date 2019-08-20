package com.vamonossoftware.validation;



import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class NotBlankRule<T,R> implements Rule<T> {

    private Function<T, R> supplier;

    public NotBlankRule(Function<T,R> supplier) {
        this.supplier = supplier;
    }

    @Override
    public ValidationResult validate(T object) {
        R value = supplier.apply(object);
        if (value == null) {
            return ValidationResult.fail();
        }
        if (value instanceof String) {
            if (StringUtils.isBlank((String)value)) {
                return ValidationResult.fail();
            }
        }
        return ValidationResult.success();
    }
}
