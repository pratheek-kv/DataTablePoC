package com.quality.collab.poc.datatable.mappers;

import java.util.Locale;

public interface DataMapper<T, D> {
    D mapToDTO(T entity, Locale locale);
}
