package com.quality.collab.poc.authorizations.dto;

import java.util.Map;

public class AuthorizationResponse {
    private Map<String, Boolean> data;

    public Map<String, Boolean> getData() {
        return data;
    }

    public void setData(Map<String, Boolean> data) {
        this.data = data;
    }
}
