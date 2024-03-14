package com.tekton.msproduct.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {

    ENABLED(1),
    DISABLED(0);

    private final int value;

    StatusEnum(int value) {
        this.value = value;
    }

    public boolean isEnabled() {
        return this.value == 1;
    }

    public static StatusEnum fromValue(int value) {
        for (StatusEnum status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}