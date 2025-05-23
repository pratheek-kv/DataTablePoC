package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto;

public class OptionDescriptor {
    private final String id;
    private final String name;

    public OptionDescriptor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}
