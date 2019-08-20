package com.vamonossoftware.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResults {

    private final List<ValidationResult> results = new ArrayList<>();

    private boolean success = true;

    public void add(ValidationResult result) {
        this.results.add(result);
        if (result.isFailure()) {
            this.success = false;
        }
    }

    public boolean isFailure() {
        return !success;
    }

    public int getSize() {
        return results.size();
    }
}
