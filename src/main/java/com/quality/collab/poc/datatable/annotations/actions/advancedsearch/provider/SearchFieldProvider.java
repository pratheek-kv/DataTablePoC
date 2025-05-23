package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider;

import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.ClauseDescriptor;

import java.util.List;

public interface SearchFieldProvider {
    List<ClauseDescriptor> getClauses(String searchFieldId);
}
