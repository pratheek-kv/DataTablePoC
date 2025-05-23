package com.quality.collab.poc.mappers;

import com.quality.collab.poc.datatable.mappers.DataMapper;
import com.quality.collab.poc.dto.QualityNotification;
import com.quality.collab.poc.model.QualityNotificationModel;
import com.quality.collab.poc.service.TranslationService;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class QualityNotificationMapper implements DataMapper<QualityNotificationModel, QualityNotification> {

    private final TranslationService translationService;

    public QualityNotificationMapper() {
        this.translationService = new TranslationService();
    }

    public QualityNotification mapToDTO(QualityNotificationModel notification, Locale locale) {
        QualityNotification dto = new QualityNotification();

        // Set basic fields
        dto.setId(notification.getId());
        dto.setNotificationType(notification.getNotificationType().toString());
        dto.setSupplier(notification.getSupplier());
        dto.setOrderNumber(notification.getOrderNumber());
        dto.setBatchNo(notification.getBatchNo());
        dto.setMaterial(notification.getMaterial());
        dto.setSerialNumber(notification.getSerialNumber());
        dto.setCriticality(notification.getCriticality().toString());
        dto.setStatus(notification.getStatus().toString());

        // Translate enum labels using the TranslationService
        dto.setNotificationTypeLabel(translationService.getNotificationTypeLabel(notification.getNotificationType().toString(), locale));
        dto.setCriticalityLabel(translationService.getCriticalityLabel(notification.getCriticality().toString(), locale));
        dto.setStatusLabel(translationService.getStatusLabel(notification.getStatus().toString(), locale));

        return dto;
    }

}
