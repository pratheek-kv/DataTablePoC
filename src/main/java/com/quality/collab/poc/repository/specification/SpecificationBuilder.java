package com.quality.collab.poc.repository.specification;

import com.quality.collab.poc.datatable.dto.filtercriteria.FilterCriteria;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {

    Specification<T> containsInAllStringFields(String keyword);

    Specification<T> fromAdvancedSearch(FilterCriteria dto);
}
