package com.quality.collab.poc.model;

import com.quality.collab.poc.enums.Criticality;
import com.quality.collab.poc.enums.NotificationType;
import com.quality.collab.poc.enums.Status;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class QualityNotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private String supplier;
    private Integer orderNumber;
    private Integer batchNo;
    private String material;
    private String serialNumber;


    @Enumerated(EnumType.STRING)
    private Criticality criticality;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
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

    public Criticality getCriticality() {
        return criticality;
    }

    public void setCriticality(Criticality criticality) {
        this.criticality = criticality;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
