package com.vamonossoftware.validation;



import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class DistinctRule<T,R> implements Rule<T> {

    private Function<T, R> supplier;
    private Set<R> distinctValues = new HashSet<>();

    public DistinctRule(Function<T,R> supplier) {
        this.supplier = supplier;
    }

    @Override
    public ValidationResult validate(T object) {
        R value = supplier.apply(object);
        if (distinctValues.contains(value)) {
            return ValidationResult.fail();
        }
        distinctValues.add(value);
        return ValidationResult.success();
    }
}
