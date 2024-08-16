package com.cisco.model;

import spinjar.com.fasterxml.jackson.core.JsonParser;
import spinjar.com.fasterxml.jackson.core.JsonProcessingException;
import spinjar.com.fasterxml.jackson.core.JsonToken;
import spinjar.com.fasterxml.jackson.databind.DeserializationContext;
import spinjar.com.fasterxml.jackson.databind.JsonNode;
import spinjar.com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class SubscriberAddedEventDeserializer extends StdDeserializer<SubscriberAddedEvent> {
    public SubscriberAddedEventDeserializer() {
        this(null);
    }

    public SubscriberAddedEventDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SubscriberAddedEvent deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node;
        if (jp.getCurrentToken() == null) {
            jp.nextToken();  // Move to the first token if needed
        }

        // Check if the current token is a START_OBJECT (i.e., the start of the JSON object)
        if (jp.getCurrentToken() == JsonToken.VALUE_STRING) {
            // If the JSON is a string, we might need to parse it again as JSON
            String jsonString = jp.getText();

            // Parse the string into a JsonNode
            node = jp.getCodec().readTree(jp.getCodec().getFactory().createParser(jsonString));
        } else {
            // Parse the JSON into a JsonNode
            node = jp.getCodec().readTree(jp);
        }
        System.out.println("Parsed JSON Node: " + node.toString());
        String createdOn=node.get("createdOn").textValue();
        return SubscriberAddedEvent.builder().withCreatedOn(createdOn).build();
    }
}
