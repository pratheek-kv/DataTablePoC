package com.quality.collab.poc.datatable;

import com.quality.collab.poc.datatable.annotations.DataTable;
import com.quality.collab.poc.datatable.annotations.Column;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.AdvancedSearch;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Clause;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Option;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.Value;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.ClauseDescriptor;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.OptionDescriptor;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.ValueFieldDescriptor;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider.DefaultSearchFieldProvider;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider.SearchFieldProvider;
import com.quality.collab.poc.datatable.annotations.actions.simplesearch.SimpleSearch;
import com.quality.collab.poc.datatable.annotations.actions.viewdropdown.ViewDropdownAction;
import com.quality.collab.poc.datatable.dto.DataTableMetadata;
import com.quality.collab.poc.datatable.dto.fields.ColumnDetails;
import com.quality.collab.poc.datatable.dto.toolbaractions.ToolbarAction;
import com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch.FieldOption;
import com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch.FilterByCondition;
import com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch.RelatedField;
import com.quality.collab.poc.datatable.dto.toolbaractions.viewdropdown.Prop;
import com.quality.collab.poc.datatable.dto.toolbaractions.viewdropdown.SelectOption;
import com.quality.collab.poc.datatable.dto.toolbaractions.viewdropdown.ViewDropdown;
import com.quality.collab.poc.datatable.enums.FieldType;
import com.quality.collab.poc.datatable.utils.StringUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Component
public class TableBuilder {

    protected final MessageSource messageSource;

    public TableBuilder(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public DataTableMetadata buildTableMetadata(String tableName, List<Class<?>> candidates) {
        DataTableMetadata tableMetadata = new DataTableMetadata();
        Class<?> entityClass = findEntityByName(tableName, candidates);
        List<ColumnDetails> columns = this.getColumnsFromEntity(entityClass);
        tableMetadata.setColumns(columns);
        List<ToolbarAction> toolbarActions = this.getToolbarActions(entityClass);
        tableMetadata.setToolbarActions(toolbarActions);
        return tableMetadata;
    }

    public Class<?> findEntityByName(String name, List<Class<?>> candidates) {
        for (Class<?> clazz : candidates) {
            DataTable annotation = clazz.getAnnotation(DataTable.class);
            if (annotation != null && annotation.name().equals(name)) {
                return clazz;
            }
        }
        throw new IllegalArgumentException("No entity found with name: " + name);
    }


    private List<ColumnDetails> getColumnsFromEntity(Class<?> entityClass) {
        List<ColumnDetails> columns = new ArrayList<>();
        Locale locale = LocaleContextHolder.getLocale();

        for (java.lang.reflect.Field field : entityClass.getDeclaredFields()) {
            Column annotation = field.getAnnotation(Column.class);
            if (annotation != null) {
                ColumnDetails column = new ColumnDetails();
                String labelKey = annotation.label();
                if (labelKey != null && labelKey.matches("^\\{[^{}]+\\}$")) {
                    String extracted = labelKey.substring(1, labelKey.length() - 1);
                    String translated = this.messageSource.getMessage(extracted, null, extracted, locale);
                    column.setTitle(translated);
                } else {
                    column.setTitle(labelKey);
                }
                column.setField(field.getName());
                column.setAlign(annotation.align());
                column.setSortable(annotation.sortable());
                // headerCellProps handling omitted for brevity
                columns.add(column);
            }
        }
        return columns;
    }

    private List<ToolbarAction> getToolbarActions(Class<?> entityClass) {
        List<ToolbarAction> actions = new ArrayList<>();

        ToolbarAction viewOptionsAction = this.processViewOptionsAction(entityClass);
        if (viewOptionsAction != null) {
            actions.add(viewOptionsAction);
        }
        ToolbarAction simpleSearchAction = this.processSimpleSearchAction(entityClass);
        if (simpleSearchAction != null) {
            actions.add(simpleSearchAction);
        }

        ToolbarAction advancedSearch = this.processAdvancedSearchAction(entityClass);
        if (simpleSearchAction != null) {
            actions.add(advancedSearch);
        }

        return  actions;
    }

    private ToolbarAction processViewOptionsAction(Class<?> entityClass) {
        ViewDropdown action = new ViewDropdown();
        ViewDropdownAction annotation = entityClass.getAnnotation(ViewDropdownAction.class);
        if (annotation != null) {
            Prop prop = new Prop();
            ViewDropdownAction.Props propsAnno = annotation.props();
            if(propsAnno != null) {
                prop.setAllowCreate(propsAnno.allowCreate());
                prop.setCreateViewUrl(propsAnno.createViewUrl());
                prop.setEditViewUrl(propsAnno.editViewUrl());
                prop.setRecordExistsUrl(propsAnno.recordExistsUrl());

                List<ViewDropdownAction.SelectOption> selectOptions = Arrays.asList(propsAnno.selectOptions());
                List<SelectOption> selectOptionList = new ArrayList<>();
                for (ViewDropdownAction.SelectOption option : selectOptions) {
                    selectOptionList.add(new SelectOption(option.id(), StringUtil.getStringOrDefault(option.name(), messageSource) , option.favorite(), option.hasRecords(), option.isTemporary(), option.editable(), option.recordCount()));
                }
                prop.setSelectOptions(selectOptionList);
                action.setProps(prop);
            }
            return action;
        }
        return null;
    }

    private ToolbarAction processSimpleSearchAction(Class<?> entityClass) {
        SimpleSearch annotation = entityClass.getAnnotation(SimpleSearch.class);
        if (annotation != null && annotation.enabled()) {
            return new com.quality.collab.poc.datatable.dto.toolbaractions.simplesearch.SimpleSearch();
        }
        return null;
    }

    private ToolbarAction processAdvancedSearchAction(Class<?> entityClass) {
        AdvancedSearch annotation = entityClass.getAnnotation(AdvancedSearch.class);
        if (annotation != null && annotation.enabled()) {
            com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch.AdvancedSearch advancesSearch = new com.quality.collab.poc.datatable.dto.toolbaractions.advancedsearch.AdvancedSearch();
            advancesSearch.setEnableAddOnlyOnLastRow(annotation.enableAddOnlyOnLastRow());
            advancesSearch.setEnableGrouping(annotation.enableGrouping());
            advancesSearch.setEnableMatching(annotation.enableMatching());
            advancesSearch.setMaxGroups(annotation.maxGroups());
            FilterByCondition filterByCondition = new FilterByCondition();
            filterByCondition.setFieldName("filterBy");
            filterByCondition.setFieldLabel(StringUtil.getStringOrDefault("{search.field.filter.by}",messageSource));
            filterByCondition.setFieldType(FieldType.SELECT);
            filterByCondition.setDefaultOption(annotation.defaultFilterBy());

            List<FieldOption> fieldOptions = new ArrayList<>();
            for (java.lang.reflect.Field field : entityClass.getDeclaredFields()) {
                AdvancedSearch.Field fieldAnnotation = field.getAnnotation(AdvancedSearch.Field.class);
                if(fieldAnnotation != null){
                    if (fieldAnnotation.provider() != DefaultSearchFieldProvider.class) {
                        fieldOptions.add(this.getFieldOptionFromProvider(fieldAnnotation, field.getName()));
                    } else {
                        fieldOptions.add(this.getFieldOptionFromAnnotation(fieldAnnotation, field.getName()));
                    }
                }
            }

            filterByCondition.setFieldOptions(fieldOptions);
            advancesSearch.setFilterByCondition(filterByCondition);
            return advancesSearch;

        }
        return null;
    }


    private FieldOption getFieldOptionFromProvider(AdvancedSearch.Field fieldAnnotation, String fieldName){
        // Use provider class
        SearchFieldProvider provider = null;
        try {
            provider = fieldAnnotation.provider().getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        List<ClauseDescriptor> clauses = provider.getClauses(fieldName);
        if(clauses != null && !clauses.isEmpty()){
            FieldOption fieldOption = new FieldOption();
            fieldOption.setId(fieldName);
            fieldOption.setName(StringUtil.getStringOrDefault(fieldAnnotation.label(),messageSource));
            List<RelatedField> relatedFields = new ArrayList<>();

            RelatedField relatedClauseField = new RelatedField();
            relatedClauseField.setFieldName("filterClause");
            relatedClauseField.setFieldLabel(StringUtil.getStringOrDefault("{search.field.clause}",messageSource));
            relatedClauseField.setFieldType(fieldAnnotation.clauseFieldType());
            relatedClauseField.setDefaultOption(fieldAnnotation.defaultClause());
            relatedClauseField.setFieldOptions(new ArrayList<>());
            for(ClauseDescriptor clause : clauses){
                FieldOption clauseOption = new FieldOption();
                clauseOption.setId(clause.getId());
                clauseOption.setName(StringUtil.getStringOrDefault(clause.getName(),messageSource));
                clauseOption.setRelatedFields(new ArrayList<>());
                for(ValueFieldDescriptor valueField : clause.getRelatedFields()){
                    RelatedField relatedValueField = new RelatedField();
                    relatedValueField.setFieldName(valueField.getId());
                    relatedValueField.setFieldLabel(StringUtil.getStringOrDefault(valueField.getName(),messageSource));
                    relatedValueField.setFieldType(fieldAnnotation.clauseFieldType());
                    relatedValueField.setDefaultOption(valueField.getDefaultOption());
                    relatedValueField.setFieldOptions(new ArrayList<>());
                    for(OptionDescriptor optionDescriptor : valueField.getFieldOptions()){
                        FieldOption option = new FieldOption();
                        option.setId(optionDescriptor.getId());
                        option.setName(StringUtil.getStringOrDefault(optionDescriptor.getName(),messageSource));
                        relatedValueField.getFieldOptions().add(option);
                    }
                    clauseOption.getRelatedFields().add(relatedValueField);
                }
                relatedClauseField.getFieldOptions().add(clauseOption);
            }
            relatedFields.add(relatedClauseField);
            fieldOption.setRelatedFields(relatedFields);
            return fieldOption;

        }

        return null;
    }

    private FieldOption getFieldOptionFromAnnotation(AdvancedSearch.Field fieldAnnotation, String fieldName){

            FieldOption fieldOption = new FieldOption();
            fieldOption.setId(fieldName);
            fieldOption.setName(StringUtil.getStringOrDefault(fieldAnnotation.label(),messageSource));
            List<RelatedField> relatedFields = new ArrayList<>();

            RelatedField relatedClauseField = new RelatedField();
            relatedClauseField.setFieldType(fieldAnnotation.clauseFieldType());
            relatedClauseField.setDefaultOption(fieldAnnotation.defaultClause());
            relatedClauseField.setFieldOptions(new ArrayList<>());
            relatedClauseField.setFieldName(fieldAnnotation.clauseFieldName());
            relatedClauseField.setFieldLabel(StringUtil.getStringOrDefault(fieldAnnotation.clauseFieldLabel(), messageSource));
        Clause[] clauses = fieldAnnotation.clauses();
        if(clauses != null) {
            for (Clause clause : clauses) {

                FieldOption clauseOption = new FieldOption();
                clauseOption.setId(clause.id());
                clauseOption.setName(StringUtil.getStringOrDefault(clause.name(), messageSource));
                clauseOption.setRelatedFields(new ArrayList<>());
                for (Value valueField : clause.values()) {
                    RelatedField relatedValueField = new RelatedField();
                    relatedValueField.setFieldName(valueField.name());
                    relatedValueField.setFieldLabel(StringUtil.getStringOrDefault(valueField.label(), messageSource));
                    relatedValueField.setFieldType(valueField.fieldType());
                    relatedValueField.setDefaultOption(valueField.defaultOption());
                    relatedValueField.setFieldOptions(new ArrayList<>());
                    for (Option optionDescriptor : valueField.fieldOptions()) {
                        FieldOption option = new FieldOption();
                        option.setId(optionDescriptor.id());
                        option.setName(StringUtil.getStringOrDefault(optionDescriptor.name(), messageSource));
                        relatedValueField.getFieldOptions().add(option);
                    }
                    clauseOption.getRelatedFields().add(relatedValueField);
                }
                relatedClauseField.getFieldOptions().add(clauseOption);
            }
        }
            relatedFields.add(relatedClauseField);
            fieldOption.setRelatedFields(relatedFields);
            return fieldOption;

    }
}