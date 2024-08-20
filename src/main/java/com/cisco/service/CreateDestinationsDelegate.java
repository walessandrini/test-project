package com.cisco.service;

import com.cisco.model.Destination;
import com.cisco.model.HttpDestination;
import com.cisco.model.LogDestination;
import com.cisco.model.SubscriberAddedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CreateDestinationsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution){
        Map subscriberAddedEventMap = (Map) execution.getVariable("subscriberAddedEvent");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        SubscriberAddedEvent subscriberAddedEvent = objectMapper.convertValue(subscriberAddedEventMap,SubscriberAddedEvent.class);
        Map<String,String> extraParams = Map.of("tfbisevent","SubscriberUpdate");
        Destination httpDestination = HttpDestination.builder().target("direQT").extraParams(extraParams).build();
        Destination logDestination = LogDestination.builder().extraParams(extraParams).build();
        List destinations = List.of(httpDestination,logDestination);
        execution.setVariable("destinations", destinations);
        log.debug("Setting destinations for subscriber: {} ", subscriberAddedEvent);
    }
}
