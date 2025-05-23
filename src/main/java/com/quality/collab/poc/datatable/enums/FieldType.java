package com.quality.collab.poc.datatable.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FieldType {
    TEXT("text"),
    DATE("date"),
    NUMBER("number"),
    CHECKBOX("checkbox"),
    SELECT("select"),
    MULTISELECT("multiselect"),
    AUTOCOMPLETE("autocomplete"),
    MONEY("money"),
    SPINNER("spinner"),
    HIDDEN("hidden");


    private final String value;

    FieldType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static FieldType fromString(String value) {
        for (FieldType fieldType : FieldType.values()) {
            if (fieldType.value.equalsIgnoreCase(value)) {
                return fieldType;
            }
        }
        throw new IllegalArgumentException("Unknown Field type: " + value);
    }

}

