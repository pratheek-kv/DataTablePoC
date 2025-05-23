package com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quality.collab.poc.datatable.enums.FieldType;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedField {

    private Boolean enableFreeForm;
    private String fieldLabel;
    private String fieldName;
    private List<FieldOption> fieldOptions;
    private FieldType fieldType;
    private String lookupUrl;//  Eg :'/autoCompleteMock?search_term={term}'
    private String defaultOption;

    public RelatedField(Boolean enableFreeForm, String fieldLabel, String fieldName, List<FieldOption> fieldOptions, FieldType fieldType, String lookupUrl, String defaultOption) {
        this.enableFreeForm = enableFreeForm;
        this.fieldLabel = fieldLabel;
        this.fieldName = fieldName;
        this.fieldOptions = fieldOptions;
        this.fieldType = fieldType;
        this.lookupUrl = lookupUrl;
        this.defaultOption = defaultOption;
    }

    public RelatedField() {
    }

    public Boolean getEnableFreeForm() {
        return enableFreeForm;
    }

    public void setEnableFreeForm(Boolean enableFreeForm) {
        this.enableFreeForm = enableFreeForm;
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

    public List<FieldOption> getFieldOptions() {
        return fieldOptions;
    }

    public void setFieldOptions(List<FieldOption> fieldOptions) {
        this.fieldOptions = fieldOptions;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public String getLookupUrl() {
        return lookupUrl;
    }

    public void setLookupUrl(String lookupUrl) {
        this.lookupUrl = lookupUrl;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }
}
