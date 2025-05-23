package com.quality.collab.poc.datatable.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SearchFieldType {
    CLAUSE("CLAUSE"),
    VALUE("VALUE");

    private final String value;

    SearchFieldType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static SearchFieldType fromString(String value) {
        for (SearchFieldType searchFieldType : SearchFieldType.values()) {
            if (searchFieldType.value.equalsIgnoreCase(value)) {
                return searchFieldType;
            }
        }
        throw new IllegalArgumentException("Unknown action type: " + value);
    }
}
