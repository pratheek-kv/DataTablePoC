package com.quality.collab.poc.datatable.dto.toolbaractions;


import com.quality.collab.poc.datatable.enums.ActionType;

public abstract class ToolbarAction {

    ActionType actionType;

    public ToolbarAction(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }


}
