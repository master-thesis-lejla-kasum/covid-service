package com.master.covidservice.covidservice.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

public enum ApplicationType {
    VACCINE("Vakcina"),
    TEST("Test");

    @Getter
    private final String label;

    ApplicationType(String label) {
        this.label = label;
    }

    public static Optional<ApplicationType> valueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(entity -> entity.getLabel().equals(label))
                .findFirst();
    }
}
