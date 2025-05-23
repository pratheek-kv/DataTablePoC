package com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Option {
    String id();
    String name();
}
