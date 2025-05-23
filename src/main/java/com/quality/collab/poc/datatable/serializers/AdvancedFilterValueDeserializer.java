package com.quality.collab.poc.datatable.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.quality.collab.poc.datatable.dto.filtercriteria.FilterValue;

import java.io.IOException;

public class AdvancedFilterValueDeserializer extends JsonDeserializer<FilterValue> {

    @Override
    public FilterValue deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = p.getCodec().readTree(p);
        FilterValue value = new FilterValue();

        if (node.isTextual()) {
            // If the input is just a string, assign it to the 'id' field
            value.setId(node.asText());
        } else if (node.isObject()) {
            if (node.has("id")) value.setId(node.get("id").asText());
            if (node.has("name")) value.setName(node.get("name").asText());
            if (node.has("external-ref-code")) {
                value.setExternalRefCode(node.get("external-ref-code").asText());
            }
        }

        return value;
    }
}
