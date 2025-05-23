package com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quality.collab.poc.datatable.enums.FieldType;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilterByCondition {
    private String fieldLabel;
    private String fieldName;
    private FieldType fieldType;
    private String defaultOption;
    private List<FieldOption> fieldOptions;

    public FilterByCondition(String fieldLabel, String fieldName, FieldType fieldType, String defaultOption, List<FieldOption> fieldOptions) {
        this.fieldLabel = fieldLabel;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.defaultOption = defaultOption;
        this.fieldOptions = fieldOptions;
    }

    public FilterByCondition() {
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }

    public List<FieldOption> getFieldOptions() {
        return fieldOptions;
    }

    public void setFieldOptions(List<FieldOption> fieldOptions) {
        this.fieldOptions = fieldOptions;
    }
}
