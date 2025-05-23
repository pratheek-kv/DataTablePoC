package com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonCondition {
    private final Map<String, RelatedField> clauses = new HashMap<>();

    @JsonAnySetter
    public void addClause(String key, RelatedField clause) {
        clauses.put(key, clause);
    }

    @JsonAnyGetter
    public Map<String, RelatedField> getClauses() {
        return clauses;
    }

    public RelatedField getClause(String key) {
        return clauses.get(key);
    }
}

