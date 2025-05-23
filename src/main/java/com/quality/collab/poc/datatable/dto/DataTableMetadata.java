package com.quality.collab.poc.datatable.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.quality.collab.poc.datatable.dto.fields.ColumnDetails;
import com.quality.collab.poc.datatable.dto.toolbaractions.ToolbarAction;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataTableMetadata {
    private List<ColumnDetails> columns;
    private List<ToolbarAction> toolbarActions;

    public DataTableMetadata() {
    }

    public List<ColumnDetails> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDetails> columns) {
        this.columns = columns;
    }

    public List<ToolbarAction> getToolbarActions() {
        return toolbarActions;
    }

    public void setToolbarActions(List<ToolbarAction> toolbarActions) {
        this.toolbarActions = toolbarActions;
    }
}
