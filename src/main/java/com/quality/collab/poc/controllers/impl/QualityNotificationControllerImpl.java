package com.quality.collab.poc.controllers.impl;

import com.quality.collab.poc.authorizations.annotations.AuthCheck;
import com.quality.collab.poc.controllers.QualityNotificationController;
import com.quality.collab.poc.datatable.TableBuilder;
import com.quality.collab.poc.datatable.controller.DataTableControllerImpl;
import com.quality.collab.poc.datatable.dto.DataTableMetadata;
import com.quality.collab.poc.dto.QualityNotification;
import com.quality.collab.poc.mappers.QualityNotificationMapper;
import com.quality.collab.poc.model.QualityNotificationModel;
import com.quality.collab.poc.service.QualityNotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quality_notif")
public class QualityNotificationControllerImpl extends DataTableControllerImpl<QualityNotificationModel, QualityNotification> implements QualityNotificationController {

    public QualityNotificationControllerImpl(TableBuilder dataTableBuilder, QualityNotificationService baseService, QualityNotificationMapper mapper) {
        super(dataTableBuilder, baseService, "QualityNotification",mapper);
    }

    @Override
    @AuthCheck(controller = "quality_collaboration", action = "index")
    public DataTableMetadata handleGet() {
        return super.handleGet();
    }

}