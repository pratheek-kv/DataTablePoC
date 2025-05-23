package com.quality.collab.poc.datatable.annotations.actions.viewdropdown;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewDropdownAction {

    Props props();

    @interface Props {
        boolean allowCreate();
        String createViewUrl();
        String editViewUrl();
        String recordExistsUrl();
        SelectOption[] selectOptions();
    }

    @interface SelectOption {
        String id();
        String name();
        boolean favorite() default false;
        boolean hasRecords() default false;
        boolean editable() default false;
        boolean isTemporary() default false;
        int recordCount() default 0;
    }
}
