package com.vamonossoftware.validation;

import java.util.ArrayList;
import java.util.List;

// TODO add more information
public class ValidationResult {
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

    public boolean isFailure() {
        return !success;
    }
}
