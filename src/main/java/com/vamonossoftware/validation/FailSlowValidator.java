package com.vamonossoftware.validation;

import java.util.Arrays;
import java.util.List;

public class FailSlowValidator<T> implements Validator<T>{

    private List<Rule> rules;

    public FailSlowValidator(List<Rule> rules) {
        this.rules = rules;
    }

    public FailSlowValidator(Rule... rules) {
        this(Arrays.asList(rules));
    }

    public ValidationResults validate(T object) {
        final ValidationResults result = new ValidationResults();

        for (Rule rule : rules) {
            result.add(rule.validate(object));
        }

        return result;
    }
}
