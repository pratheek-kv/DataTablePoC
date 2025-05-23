package com.quality.collab.poc.datatable.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class StringUtil {
    public static String getStringOrDefault(String labelKey, MessageSource messageSource) {
        if (labelKey != null && labelKey.matches("^\\{[^{}]+\\}$")) {
            String extracted = labelKey.substring(1, labelKey.length() - 1);
            return messageSource.getMessage(extracted, null, extracted, LocaleContextHolder.getLocale());
        }
        return labelKey;
    }
}

