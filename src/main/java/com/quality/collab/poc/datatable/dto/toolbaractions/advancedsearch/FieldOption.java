package com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FieldOption {

    private String id;
    private String name;
    List<RelatedField> relatedFields;

    public FieldOption(String id, String name, List<RelatedField> relatedFields) {
        this.id = id;
        this.name = name;
        this.relatedFields = relatedFields;
    }

    public FieldOption() {
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

    public List<RelatedField> getRelatedFields() {
        return relatedFields;
    }

    public void setRelatedFields(List<RelatedField> relatedFields) {
        this.relatedFields = relatedFields;
    }
}
