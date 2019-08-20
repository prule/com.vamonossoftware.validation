package com.vamonossoftware.validation;

import java.util.Arrays;
import java.util.List;

public class FailSlowValidator<T> implements Validator<T>{

    private List<Rule> rules;
    final ValidationResults results = new ValidationResults();

    public FailSlowValidator(List<Rule> rules) {
        this.rules = rules;
    }

    public FailSlowValidator(Rule... rules) {
        this(Arrays.asList(rules));
    }

    public ValidationResults validate(T object) {

        for (Rule rule : rules) {
            final ValidationResult result = rule.validate(object);
            if (result.isFailure()) {
                this.results.add(result);
            }
        }

        return results;
    }

    public ValidationResults getResults() {
        return results;
    }
}
