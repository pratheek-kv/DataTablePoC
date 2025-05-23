package com.quality.collab.poc.datatable.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String label();
    String align() default "left";
    boolean sortable() default false;
    CellProps[] headerCellProps() default {};

    @interface CellProps {
        String tooltipContent() default "";
        String verticalAlign() default "";
    }
}


