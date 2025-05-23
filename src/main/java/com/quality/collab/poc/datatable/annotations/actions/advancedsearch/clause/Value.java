package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause;

import com.quality.collab.poc.datatable.enums.FieldType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Value {

    String name() default "filterValue";
    String label() default "{search.field.value}";
    FieldType fieldType();
    boolean enableFreeForm() default false;
    String defaultOption() default "";
    String lookupUrl() default "";
    Option[] fieldOptions() default {};
}

