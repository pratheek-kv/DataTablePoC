package com.quality.collab.poc.datatable.dto.toolbaractions.viewdropdown;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prop {
    private Boolean allowCreate;
    private String createViewUrl;       //  /data_table/new_view?key=<table_id>
    private String editViewUrl;         //  /data_table/edit_view",
    private String  recordExistsUrl;    //  /data_table/favorite_count?key=<table_id>",
    private List<SelectOption> selectOptions;

    public Prop() {
    }

    public Prop(Boolean allowCreate, String createViewUrl, String editViewUrl, String recordExistsUrl, List<SelectOption> selectOptions) {
        this.allowCreate = allowCreate;
        this.createViewUrl = createViewUrl;
        this.editViewUrl = editViewUrl;
        this.recordExistsUrl = recordExistsUrl;
        this.selectOptions = selectOptions;
    }

    public Boolean getAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(Boolean allowCreate) {
        this.allowCreate = allowCreate;
    }

    public String getCreateViewUrl() {
        return createViewUrl;
    }

    public void setCreateViewUrl(String createViewUrl) {
        this.createViewUrl = createViewUrl;
    }

    public String getEditViewUrl() {
        return editViewUrl;
    }

    public void setEditViewUrl(String editViewUrl) {
        this.editViewUrl = editViewUrl;
    }

    public String getRecordExistsUrl() {
        return recordExistsUrl;
    }

    public void setRecordExistsUrl(String recordExistsUrl) {
        this.recordExistsUrl = recordExistsUrl;
    }

    public List<SelectOption> getSelectOptions() {
        return selectOptions;
    }

    public void setSelectOptions(List<SelectOption> selectOptions) {
        this.selectOptions = selectOptions;
    }
}

