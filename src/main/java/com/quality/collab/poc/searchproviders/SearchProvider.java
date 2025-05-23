package com.quality.collab.poc.searchproviders;

import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.ClauseDescriptor;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.OptionDescriptor;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.clause.dto.ValueFieldDescriptor;
import com.quality.collab.poc.datatable.annotations.actions.advancedsearch.provider.SearchFieldProvider;
import com.quality.collab.poc.datatable.enums.FieldType;
import com.quality.collab.poc.datatable.enums.SearchFieldType;
import com.quality.collab.poc.datatable.utils.StringUtil;

import java.util.List;

public class SearchProvider implements SearchFieldProvider {
    @Override
    public List<ClauseDescriptor> getClauses(String searchFieldId) {

        if(searchFieldId.equalsIgnoreCase("criticality")){
            return  getCriticality();
        }else if(searchFieldId.equalsIgnoreCase("status")){
            return getStatus();
        }
        return null;
    }

    private List<ClauseDescriptor> getCriticality(){
        return List.of(new ClauseDescriptor("eq", "{search.clause.is}", List.of(
                        new ValueFieldDescriptor("value", "{search.field.value}", FieldType.SELECT, "" ,
                                List.of(new OptionDescriptor("MAJOR","{criticality.MAJOR}"),
                                        new OptionDescriptor("MINOR","{criticality.MINOR}")
                                )

                        )
                )));
    }

    private List<ClauseDescriptor> getStatus(){
        return List.of( new ClauseDescriptor("eq", "{search.clause.is}", List.of(
                        new ValueFieldDescriptor("value", "{search.field.value}",FieldType.SELECT, "" ,
                                List.of(new OptionDescriptor("SEND_TO_SUPPLIER","{status.SEND_TO_SUPPLIER}"),
                                        new OptionDescriptor("IN_PROCESS","{status.IN_PROCESS}"),
                                        new OptionDescriptor("CLOSED","{status.CLOSED}")
                                )

                        )
                )));
    }
}
