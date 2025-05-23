package com.quality.collab.poc.datatable.annotations.actions.advancedsearch;

import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Clause;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider.DefaultSearchFieldProvider;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider.SearchFieldProvider;
import com.quality.collab.poc.datatable.enums.FieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AdvancedSearch {
    boolean enabled() default true;
    boolean enableAddOnlyOnLastRow() default true;
    boolean enableGrouping() default false;
    boolean enableMatching() default false;
    int maxGroups() default 5;
    String defaultFilterBy() default "";

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Field {
        String label();
        FieldType clauseFieldType();
        String clauseFieldName() default "filterClause";
        String clauseFieldLabel() default "{search.field.clause}";
        String defaultClause() default "";
        Clause[] clauses() default {};
        Class<? extends SearchFieldProvider> provider() default DefaultSearchFieldProvider.class;

    }






}
