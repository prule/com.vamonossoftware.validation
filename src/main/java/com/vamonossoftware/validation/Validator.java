package com.vamonossoftware.validation;

import java.util.Arrays;
import java.util.List;

public interface Validator<T> {

    ValidationResults validate(T object);

}
