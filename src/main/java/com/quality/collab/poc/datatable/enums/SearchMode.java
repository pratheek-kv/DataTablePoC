package com.quality.collab.poc.datatable.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SearchMode {
    BASIC("basic"),
    ADVANCED("advanced");

    private final String value;

    SearchMode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static SearchMode fromString(String value) {
        for (SearchMode actionType : SearchMode.values()) {
            if (actionType.value.equalsIgnoreCase(value)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Unknown search mode: " + value);
    }
}

