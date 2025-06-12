package com.quality.collab.poc.dto;

import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.AdvancedSearch;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Clause;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Option;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Value;
import com.quality.collab.poc.datatable.annotations.actions.simplesearch.SimpleSearch;
import com.quality.collab.poc.datatable.annotations.actions.viewdropdown.ViewDropdownAction;
import com.quality.collab.poc.datatable.annotations.DataTable;
import com.quality.collab.poc.datatable.annotations.Column;
import com.quality.collab.poc.datatable.enums.FieldType;
import com.quality.collab.poc.searchproviders.SearchProvider;

@DataTable(name = "QualityNotification")
@ViewDropdownAction(props = @ViewDropdownAction.Props(
        allowCreate = false,
        createViewUrl = "http://localhost:8080/data_table/new_view?key=<table_id>",
        editViewUrl = "/data_table/edit_view",
        recordExistsUrl = "/data_table/favorite_count?key=<table_id>",
        selectOptions = {
                @ViewDropdownAction.SelectOption(id = "All", name = "{notification.view.all}"),
                @ViewDropdownAction.SelectOption(id="limited", name= "{notification.view.limited}")
        }
))
@SimpleSearch
@AdvancedSearch(defaultFilterBy = "criticality")

public class QualityNotification {

    @Column(label = "{notification.id}", align = "center", sortable = true)
    private Long id;
    @AdvancedSearch.Field(label = "{notification.type}", clauseFieldType = FieldType.SELECT,
            clauses = { @Clause( id = "eq", name = "{search.clause.is}",
                               values = {
                                    @Value(
                                       fieldType = FieldType.SELECT,
                                       defaultOption = "PACKAGING",
                                       fieldOptions = {
                                               @Option(id = "PROCESS_DEVIATION", name = "Process Deviation"),
                                               @Option(id = "PRODUCT_DEVIATION", name = "Product Deviation"),
                                               @Option(id = "PACKAGING", name = "Packaging"),
                                               @Option(id = "CUSTOMER_COMPLAINT", name = "Customer Complaint")
                                       }
                                    ),
                                       @Value(
                                               label = "Expand Child",
                                               fieldType = FieldType.CHECKBOX
                                       )
                               })
    }
    )
    private String notificationType;  // Raw enum value
    @AdvancedSearch.Field(label = "{notification.criticality}",clauseFieldType = FieldType.SELECT,  provider = SearchProvider.class)
    private String criticality;  // Raw enum value
    @AdvancedSearch.Field(label = "{notification.status}", clauseFieldType = FieldType.SELECT, provider = SearchProvider.class)
    private String status;  // Raw enum value

    @Column(label = "{notification.supplier}", align = "center", sortable = true)
    private String supplier;
    @Column(label = "{notification.orderNum}", align = "center", sortable = true)
    private Integer orderNumber;
    private Integer batchNo;
    @Column(label = "{notification.material}", align = "center", sortable = true)
    @AdvancedSearch.Field(label = "{notification.material}", clauseFieldType = FieldType.CHECKBOX,
    clauses = { @Clause( id = "contains", name = "{search.clause.contains}")}
    )
    private String material;
    private String serialNumber;
    @Column(label = "{notification.type}", align = "center", sortable = true)
    private String notificationTypeLabel;
    @Column(label = "{notification.criticality}", align = "center", sortable = true)
    private String criticalityLabel;
    @Column(label = "{notification.status}", align = "center", sortable = true)
    private String statusLabel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotificationTypeLabel() {
        return notificationTypeLabel;
    }

    public void setNotificationTypeLabel(String notificationTypeLabel) {
        this.notificationTypeLabel = notificationTypeLabel;
    }

    public String getCriticalityLabel() {
        return criticalityLabel;
    }

    public void setCriticalityLabel(String criticalityLabel) {
        this.criticalityLabel = criticalityLabel;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }
}
