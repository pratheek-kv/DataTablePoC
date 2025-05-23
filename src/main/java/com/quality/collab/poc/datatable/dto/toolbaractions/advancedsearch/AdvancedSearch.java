package com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quality.collab.poc.datatable.dto.toolbaractions.ToolbarAction;
import com.quality.collab.poc.datatable.enums.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedSearch extends ToolbarAction {

    private boolean enableAddOnlyOnLastRow;
    private boolean enableGrouping;
    private boolean enableMatching;
    private FilterByCondition filterByCondition;
    private CommonCondition commonConditions;
    private Integer maxGroups;

    public AdvancedSearch(boolean enableAddOnlyOnLastRow, boolean enableGrouping, boolean enableMatching, FilterByCondition filterByCondition, CommonCondition commonConditions, Integer maxGroups) {
        super(ActionType.ADVANCED_SEARCH);
        this.enableAddOnlyOnLastRow = enableAddOnlyOnLastRow;
        this.enableGrouping = enableGrouping;
        this.enableMatching = enableMatching;
        this.filterByCondition = filterByCondition;
        this.commonConditions = commonConditions;
        this.maxGroups = maxGroups;
    }

    public AdvancedSearch() {
        super(ActionType.ADVANCED_SEARCH);
    }

    public CommonCondition getCommonConditions() {
        return commonConditions;
    }

    public void setCommonConditions(CommonCondition commonConditions) {
        this.commonConditions = commonConditions;
    }

    public boolean isEnableAddOnlyOnLastRow() {
        return enableAddOnlyOnLastRow;
    }

    public void setEnableAddOnlyOnLastRow(boolean enableAddOnlyOnLastRow) {
        this.enableAddOnlyOnLastRow = enableAddOnlyOnLastRow;
    }

    public boolean isEnableGrouping() {
        return enableGrouping;
    }

    public void setEnableGrouping(boolean enableGrouping) {
        this.enableGrouping = enableGrouping;
    }

    public boolean isEnableMatching() {
        return enableMatching;
    }

    public void setEnableMatching(boolean enableMatching) {
        this.enableMatching = enableMatching;
    }

    public FilterByCondition getFilterByCondition() {
        return filterByCondition;
    }

    public void setFilterByCondition(FilterByCondition filterByCondition) {
        this.filterByCondition = filterByCondition;
    }

    public Integer getMaxGroups() {
        return maxGroups;
    }

    public void setMaxGroups(Integer maxGroups) {
        this.maxGroups = maxGroups;
    }
}

