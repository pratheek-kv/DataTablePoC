package com.quality.collab.poc.datatable.dto.toolbaractions.simplesearch;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.quality.collab.poc.datatable.dto.toolbaractions.ToolbarAction;
import com.quality.collab.poc.datatable.enums.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleSearch extends ToolbarAction {
    public SimpleSearch() {
        super(ActionType.SIMPLE_SEARCH);
    }
}
