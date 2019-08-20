package com.vamonossoftware.validation;

public interface Rule<T> {
    ValidationResult validate(T object);
}
