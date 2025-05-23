package com.quality.collab.poc.datatable.dto.filtercriteria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterValue {
    private String id;
    private String name;

    @JsonProperty("external-ref-code")
    private String externalRefCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalRefCode() {
        return externalRefCode;
    }

    public void setExternalRefCode(String externalRefCode) {
        this.externalRefCode = externalRefCode;
    }
}
