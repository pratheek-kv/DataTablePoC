package com.quality.collab.poc.repository.specification;

import com.quality.collab.poc.datatable.dto.filtercriteria.AdvancedSearch;
import com.quality.collab.poc.datatable.dto.filtercriteria.FilterCriteria;
import com.quality.collab.poc.model.QualityNotificationModel;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class QualityNotificationSpecification implements SpecificationBuilder<QualityNotificationModel> {

    @Override
    public Specification<QualityNotificationModel> containsInAllStringFields(String keyword) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            for (Field field : QualityNotificationModel.class.getDeclaredFields()) {
                if (field.getType().equals(String.class)) {
                    predicates.add(cb.like(cb.lower(root.get(field.getName())), "%" + keyword.toLowerCase() + "%"));
                }
            }

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public Specification<QualityNotificationModel> fromAdvancedSearch(FilterCriteria dto) {
        List<List<AdvancedSearch>> groups = dto.getAdvancedSearch();
        boolean outerIsOr = "all".equalsIgnoreCase(dto.getMatchBy());

        Specification<QualityNotificationModel> finalSpec = null;

        for (List<AdvancedSearch> group : groups) {
            Specification<QualityNotificationModel> groupSpec = null;

            for (AdvancedSearch filter : group) {
                Specification<QualityNotificationModel> spec = getFilterSpecification(filter);

                groupSpec = (groupSpec == null) ? spec : groupSpec.and(spec);
            }

            finalSpec = (finalSpec == null)
                    ? groupSpec
                    : (outerIsOr ? finalSpec.or(groupSpec) : finalSpec.and(groupSpec));
        }

        return finalSpec;
    }

    private static Specification<QualityNotificationModel> getFilterSpecification(AdvancedSearch filter) {
        return (root, query, cb) -> {
            Path<String> path = root.get(filter.getFilterBy());
            String value = filter.getFilterValue().getId();

            return switch (filter.getFilterClause()) {
                case "eq" -> cb.equal(path, value);
                case "ne" -> cb.notEqual(path, value);
                case "like" -> cb.like(path, "%" + value + "%");
                case "gt" -> cb.greaterThan(path, value);
                case "lt" -> cb.lessThan(path, value);
                // Add more operators as needed
                default -> null;
            };
        };
    }
}
