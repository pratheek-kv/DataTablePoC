package com.quality.collab.poc.datatable.annotations.actions.simplesearch;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SimpleSearch {
    boolean enabled() default true;
}
