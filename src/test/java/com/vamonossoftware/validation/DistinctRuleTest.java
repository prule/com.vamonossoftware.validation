package com.vamonossoftware.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctRuleTest {

    @Test
    public void WHEN_duplicated_THEN_should_fail() {
        final DistinctRule<SampleObject, String> rule = new DistinctRule<>(sample -> sample.getS());
        assertThat(rule.validate(new SampleObject("1", 1)).isFailure()).isFalse();
        assertThat(rule.validate(new SampleObject("2", 1)).isFailure()).isFalse();
        assertThat(rule.validate(new SampleObject("1", 1)).isFailure()).isTrue();
    }

}
