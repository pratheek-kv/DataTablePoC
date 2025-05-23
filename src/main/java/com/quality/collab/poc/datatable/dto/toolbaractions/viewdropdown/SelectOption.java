package com.quality.collab.poc.datatable.dto.toolbaractions.viewdropdown;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectOption {
    private String id;
    private String name;
    private Boolean favorite;
    private Boolean hasRecords;
    private Boolean isTemporary;
    private Boolean editable;
    private Integer recordCount;

    public SelectOption() {
    }

    public SelectOption(String id, String name, Boolean favorite, Boolean hasRecords, Boolean isTemporary, Boolean editable, Integer recordCount) {
        this.id = id;
        this.name = name;
        this.favorite = favorite;
        this.hasRecords = hasRecords;
        this.isTemporary = isTemporary;
        this.editable = editable;
        this.recordCount = recordCount;
    }

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

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getHasRecords() {
        return hasRecords;
    }

    public void setHasRecords(Boolean hasRecords) {
        this.hasRecords = hasRecords;
    }

    public Boolean getTemporary() {
        return isTemporary;
    }

    public void setTemporary(Boolean temporary) {
        isTemporary = temporary;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }
}

