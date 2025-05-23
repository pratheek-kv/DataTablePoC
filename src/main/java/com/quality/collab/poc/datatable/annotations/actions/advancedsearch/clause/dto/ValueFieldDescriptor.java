package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto;

import com.quality.collab.poc.datatable.enums.FieldType;
import com.quality.collab.poc.datatable.enums.SearchFieldType;

import java.util.List;

public class ValueFieldDescriptor {
    private final String id;
    private final String name;
    private final FieldType fieldType;
    private final Boolean enableFreeForm;
    private final String defaultOption;
    private final String lookupUrl;
    private final List<OptionDescriptor> fieldOptions;

    public ValueFieldDescriptor(
            String id, String name, FieldType fieldType, Boolean enableFreeForm,
            String defaultOption, String lookupUrl, List<OptionDescriptor> fieldOptions
    ) {
        this.id = id;
        this.name = name;
        this.fieldType = fieldType;
        this.enableFreeForm = enableFreeForm;
        this.defaultOption = defaultOption;
        this.lookupUrl = lookupUrl;
        this.fieldOptions = fieldOptions;
    }

    public ValueFieldDescriptor(
            String id, String name, FieldType fieldType,
            String defaultOption, List<OptionDescriptor> fieldOptions
    ) {
        this.id = id;
        this.name = name;
        this.fieldType = fieldType;
        this.defaultOption = defaultOption;
        this.fieldOptions = fieldOptions;
        this.enableFreeForm = null;
        this.lookupUrl = null;
    }

    public String getId() {
        return id;
    }

    public FieldType getFieldType() {
        return fieldType;
    }


    public String getDefaultOption() {
        return defaultOption;
    }

    public String getLookupUrl() {
        return lookupUrl;
    }

    public List<OptionDescriptor> getFieldOptions() {
        return fieldOptions;
    }

    public String getName() {
        return name;
    }

    public Boolean getEnableFreeForm() {
        return enableFreeForm;
    }
}
