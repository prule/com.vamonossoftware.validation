package com.vamonossoftware.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FailSlowValidatorTest {

    @Test
    public void WHEN_failing_slow_THEN_failures_should_be_collected() throws ValidationException {
        final NotBlankRule<SampleObject, String> notBlank = new NotBlankRule<>(SampleObject::getS);
        final Validator<SampleObject> validator = new FailSlowValidator<>(notBlank);

        assertThat(validator.validate(new SampleObject("good", 1)).isFailure()).isFalse();
        // trigger first failure
        assertThat(validator.validate(new SampleObject("", 2)).isFailure()).isTrue();
        // after first failure, results still indicate failure
        assertThat(validator.validate(new SampleObject("good", 3)).isFailure()).isTrue();

        assertThat(validator.getResults().getSize()).isEqualTo(1);
        assertThat(validator.getResults().isFailure()).isTrue();
    }

}
