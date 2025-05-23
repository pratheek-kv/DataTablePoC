package com.quality.collab.poc.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class TranslationService {

    private static final String BASE_NAME = "messages";  // base name for the properties files

    public String getNotificationTypeLabel(String notificationType, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        return bundle.getString("notificationType." + notificationType);
    }

    public String getCriticalityLabel(String criticality, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        return bundle.getString("criticality." + criticality);
    }

    public String getStatusLabel(String status, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(BASE_NAME, locale);
        return bundle.getString("status." + status);
    }
}
