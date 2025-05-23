package com.quality.collab.poc.datatable.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataTable {
    String name();
}