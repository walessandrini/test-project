package com.cisco.service;

import com.cisco.model.Destination;
import com.cisco.model.HttpDestination;
import com.cisco.model.LogDestination;
import com.cisco.model.SubscriberAddedEvent;
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
        SubscriberAddedEvent subscriberAdded = (SubscriberAddedEvent) execution.getVariable("subscriberAddedEvent");
        Map<String,String> extraParams = Map.of("tfbisevent","SubscriberUpdate");
        Destination httpDestination = HttpDestination.builder().target("direQT").extraParams(extraParams).build();
        Destination logDestination = LogDestination.builder().extraParams(extraParams).build();
        List destinations = List.of(httpDestination,logDestination);
        execution.setVariable("destinations", destinations);
        log.debug("Setting destinations for subscriber: {} ", subscriberAdded);
    }
}
