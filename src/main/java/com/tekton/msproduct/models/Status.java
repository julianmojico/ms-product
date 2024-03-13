package com.tekton.msproduct.models;

public enum Status {
    ENABLED(1),
    DISABLED(0);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEnabled() {
        return this.value == 1;
    }

    public static Status fromValue(int value) {
        for (Status status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}