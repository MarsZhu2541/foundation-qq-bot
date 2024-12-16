package com.mars.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MessageType {
    TEXT(0),
    MARKDOWN(2),
    ARK(3),
    EMBED(4),
    MEDIA(7);

    private final int value;

    MessageType(int value) {
        this.value = value;
    }

    @JsonValue
    public int getValue() {
        return this.value;
    }
}