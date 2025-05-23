package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider;

import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.ClauseDescriptor;

import java.util.List;

public final class DefaultSearchFieldProvider implements SearchFieldProvider {
    @Override
    public List<ClauseDescriptor> getClauses(String searchFieldId) {
        return List.of();
    }
}
