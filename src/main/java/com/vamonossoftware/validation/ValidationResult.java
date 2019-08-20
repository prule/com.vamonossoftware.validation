package com.vamonossoftware.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private List<ValidationResult> results = new ArrayList<>();
    private boolean success;

    public ValidationResult(boolean success) {
        this.success = success;
    }

    public static ValidationResult fail() {
        return new ValidationResult(false);
    }

    public static ValidationResult success() {
        return new ValidationResult(true);
    }

    public void add(ValidationResult result) {
        results.add(result);
    }


    public boolean isFailure() {
        return !success;
    }
}
