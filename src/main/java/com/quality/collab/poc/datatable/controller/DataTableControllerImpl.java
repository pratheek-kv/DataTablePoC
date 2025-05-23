package com.quality.collab.poc.datatable.controller;

import com.quality.collab.poc.datatable.TableBuilder;
import com.quality.collab.poc.datatable.dto.DataTableMetadata;
import com.quality.collab.poc.datatable.mappers.DataMapper;
import com.quality.collab.poc.dto.QualityNotification;
import com.quality.collab.poc.service.AbstractService;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class DataTableControllerImpl<T,D> {

    private final TableBuilder dataTableBuilder;
    private final String tableId;
    private final DataMapper dataMapper;

    AbstractService<T> baseService;
    ApplicationContext applicationContext;

    public DataTableControllerImpl(TableBuilder dataTableBuilder, AbstractService<T> baseService, String tableId, DataMapper mapper) {
        this.dataTableBuilder = dataTableBuilder;
        this.baseService = baseService;
        this.tableId = tableId;
        this.dataMapper = mapper;

    }

    @GetMapping("/search_table")
    public DataTableMetadata handleGet() {
        List<Class<?>> candidates = Arrays.asList(QualityNotification.class);

        return dataTableBuilder.buildTableMetadata("QualityNotification", candidates);
    }
}