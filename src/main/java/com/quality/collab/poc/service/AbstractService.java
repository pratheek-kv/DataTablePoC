package com.quality.collab.poc.service;

import com.quality.collab.poc.datatable.dto.filtercriteria.FilterCriteria;
import com.quality.collab.poc.datatable.enums.SearchMode;
import com.quality.collab.poc.repository.BaseRepository;
import com.quality.collab.poc.repository.specification.SpecificationBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public abstract class AbstractService<T> {

    private final JpaSpecificationExecutor<T> specExecutor;
    private final JpaRepository<T, ?> repository;
    private final SpecificationBuilder<T> specification;


    protected AbstractService(BaseRepository<T, ?> repository, SpecificationBuilder<T> specification) {
        this.specExecutor = repository;
        this.repository = repository;
        this.specification = specification;
    }

    public JpaSpecificationExecutor<T> getSpecExecutor() {
        return specExecutor;
    }

    public JpaRepository<T, ?> getRepository() {
        return repository;
    }

    public Page<T> findAll(FilterCriteria request) {
        Sort sort = null;
        if(request.getSortDirection() != null){
            sort = request.getSortDirection().equalsIgnoreCase("ASC") ?
                    Sort.by(request.getSortBy()).ascending() :
                    Sort.by(request.getSortBy()).descending();
        }

        PageRequest pageRequest = sort != null ? PageRequest.of(request.getCurrentPage() - 1, request.getRowsPerPage(),sort)
                : PageRequest.of(request.getCurrentPage() - 1, request.getRowsPerPage());

        if(request.getSearchMode() == null || request.getSearchMode().equals(SearchMode.BASIC)) {
            if (request.getSearch() == null || request.getSearch().isEmpty()) {
                return repository.findAll(pageRequest);
            }

            return specExecutor.findAll(specification.containsInAllStringFields(request.getSearch()), pageRequest);
        }else{
            return specExecutor.findAll(specification.fromAdvancedSearch(request), pageRequest);
        }
    }

}
