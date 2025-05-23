package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto;

import java.util.List;

public class ClauseDescriptor {
    private final String id;
    private final String name;
    private final List<ValueFieldDescriptor> relatedFields;

    public ClauseDescriptor(String id, String name, List<ValueFieldDescriptor> relatedFields) {
        this.id = id;
        this.name = name;
        this.relatedFields = relatedFields;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<ValueFieldDescriptor> getRelatedFields() { return relatedFields; }
}
