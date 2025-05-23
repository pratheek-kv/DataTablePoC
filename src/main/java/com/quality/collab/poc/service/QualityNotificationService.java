package com.quality.collab.poc.service;


import com.quality.collab.poc.model.QualityNotificationModel;
import com.quality.collab.poc.repository.QualityNotificationRepo;
import com.quality.collab.poc.repository.specification.QualityNotificationSpecification;
import org.springframework.stereotype.Service;

@Service
public class QualityNotificationService extends AbstractService<QualityNotificationModel> {

    public QualityNotificationService(QualityNotificationRepo qualityNotificationRepository) {
        super(qualityNotificationRepository, new QualityNotificationSpecification());
    }

}