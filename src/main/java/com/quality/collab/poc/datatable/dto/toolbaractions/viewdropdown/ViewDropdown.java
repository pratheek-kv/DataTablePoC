package com.quality.collab.poc.datatable.dto.toolbaractions.viewdropdown;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.quality.collab.poc.datatable.dto.toolbaractions.ToolbarAction;
import com.quality.collab.poc.datatable.enums.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewDropdown extends ToolbarAction {

    private Prop props;

    public ViewDropdown( ) {
        super(ActionType.VIEW_DROPDOWN);
    }

    public ViewDropdown(Prop props) {
        super(ActionType.VIEW_DROPDOWN);
        this.props = props;
    }

    public Prop getProps() {
        return props;
    }

    public void setProps(Prop props) {
        this.props = props;
    }
}