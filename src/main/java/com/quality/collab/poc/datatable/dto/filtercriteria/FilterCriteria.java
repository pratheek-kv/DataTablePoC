package com.quality.collab.poc.datatable.dto.filtercriteria;

import com.quality.collab.poc.datatable.enums.SearchMode;

import java.util.List;


public class FilterCriteria {

    private List<List<AdvancedSearch>> advancedSearch;
    private String matchBy;
    private Integer currentPage;
    private Integer rowsPerPage;
    private String search;
    private SearchMode searchMode;
    private String view;
    private String sortBy;
    private String sortDirection;

    public FilterCriteria() {
    }

    public List<List<AdvancedSearch>> getAdvancedSearch() {
        return advancedSearch;
    }

    public void setAdvancedSearch(List<List<AdvancedSearch>> advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    public String getMatchBy() {
        return matchBy;
    }

    public void setMatchBy(String matchBy) {
        this.matchBy = matchBy;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(Integer rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public SearchMode getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(SearchMode searchMode) {
        this.searchMode = searchMode;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }
}

