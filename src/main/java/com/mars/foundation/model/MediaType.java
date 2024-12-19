package com.mars.foundation.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MediaType {
    IMAGE(1),
    VIDEO(2),
    AUDIO(3),
    FILE(4);

    private final int value;

    MediaType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }

}