package com.vamonossoftware.validation;

public interface Validator<T> {

    ValidationResults validate(T object) throws ValidationException;

    ValidationResults getResults();

}
