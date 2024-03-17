package com.tekton.msproduct.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum StatusEnum {

    Active(1),
    Inactive(0);


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

    public int getValue() {
        return value;
    }
}