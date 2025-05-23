package com.quality.collab.poc.datatable.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ActionType {
    ADVANCED_SEARCH("ADVANCED_SEARCH"),
    SIMPLE_SEARCH("SIMPLE_SEARCH"),
    ACTIONS_MENU("ACTIONS_MENU"),
    VIEW_DROPDOWN("VIEW_DROPDOWN");

    private final String value;

    ActionType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ActionType fromString(String value) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.value.equalsIgnoreCase(value)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Unknown action type: " + value);
    }
}