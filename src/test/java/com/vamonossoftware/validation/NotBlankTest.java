package com.vamonossoftware.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotBlankTest {

    @Test
    public void WHEN_blank_THEN_should_fail() {
        final NotBlankRule<SampleObject, String> notBlank = new NotBlankRule<>(sample -> sample.getS());

        final Validator<SampleObject> validator = new FailSlowValidator<>(notBlank);

        final ValidationResults result = validator.validate(new SampleObject("", 1));

        assertThat(result.isFailure()).isTrue();
    }

    @Test
    public void WHEN_null_THEN_should_fail() {
        final NotBlankRule<SampleObject, String> notBlank = new NotBlankRule<>(sample -> sample.getS());

        final FailSlowValidator<SampleObject> validator = new FailSlowValidator<>(notBlank);

        final ValidationResults result = validator.validate(new SampleObject(null, 1));

        assertThat(result.isFailure()).isTrue();
    }

    @Test
    public void WHEN_not_blank_THEN_should_succeed() {
        final NotBlankRule<SampleObject, String> notBlank = new NotBlankRule<>(sample -> sample.getS());

        final FailSlowValidator<SampleObject> validator = new FailSlowValidator<>(notBlank);

        final ValidationResults result = validator.validate(new SampleObject("test", 1));

        assertThat(result.isFailure()).isFalse();
    }


}
