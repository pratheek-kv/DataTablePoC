package com.quality.collab.poc.datatable.dto.fields;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnDetails {

    private String field;
    private Map<String, String> headerCellProps;
    private Boolean sortable;
    private String title;
    private String align;

    public ColumnDetails(String field, Map<String, String> headerCellProps, boolean sortable, String title, String align) {
        this.field = field;
        this.headerCellProps = headerCellProps;
        this.sortable = sortable;
        this.title = title;
        this.align = align;
    }

    public ColumnDetails() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Map<String, String> getHeaderCellProps() {
        return headerCellProps;
    }

    public void setHeaderCellProps(Map<String, String> headerCellProps) {
        this.headerCellProps = headerCellProps;
    }

    public Boolean isSortable() {
        return sortable;
    }

    public void setSortable(Boolean sortable) {
        this.sortable = sortable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }
}