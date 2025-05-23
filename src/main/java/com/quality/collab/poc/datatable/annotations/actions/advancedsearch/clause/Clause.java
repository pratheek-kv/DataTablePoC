package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause;

import com.quality.collab.poc.datatable.enums.FieldType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Clause {
    String id();
    String name();
    FieldType fieldType() default FieldType.SELECT;
    Value[] values() default {};
}

