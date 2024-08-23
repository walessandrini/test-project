package com.cisco.service;

import com.cisco.model.Destination;
import com.cisco.model.SubscriberAddedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SubscriberEventService {
    private final static String GET_DESTINATIONS_PROCESS = "get_destinations";

    public List<Destination> subscriberAdded(SubscriberAddedEvent subscriberAddedEvent) {
        return this.invokeBusinessProcess(subscriberAddedEvent);
    }

    private List<Destination> invokeBusinessProcess(SubscriberAddedEvent subscriberAddedEvent) {
        // Define process variables if needed
        List<Destination> destinations = new ArrayList<>();
        Map<String, Object> variables = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        Map subscriberAddedEventMap = objectMapper.convertValue(subscriberAddedEvent, Map.class);
        ((Map) ((Map) subscriberAddedEventMap.get("newSubscriber")).get("baseOffer")).put("timeToLive",subscriberAddedEvent.getNewSubscriber().getBaseOffer().getTimeToLive());
        ((Map)((Map) subscriberAddedEventMap.get("newSubscriber")).get("baseOffer")).put("futureTimeToLive",subscriberAddedEvent.getNewSubscriber().getBaseOffer().getFutureTimeToLive());
        variables.put("subscriberAddedEvent", subscriberAddedEventMap);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // Get the RuntimeService from the process engine
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // Start the process instance by process definition key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(GET_DESTINATIONS_PROCESS, variables);
        // Output the process instance ID
        log.info("Started process instance with ID: " + processInstance.getId());
        HistoricVariableInstance subscriberAddedEventVariable = processEngine.getHistoryService().createHistoricVariableInstanceQuery()
                .executionIdIn(processInstance.getId()).variableName("subscriberAddedEvent").singleResult();
        SubscriberAddedEvent subscriberAddedEventOutput;
        if (subscriberAddedEventVariable!=null){
            Map subscriberAddedEventOutputMap = (Map) subscriberAddedEventVariable.getValue();
            subscriberAddedEventOutput = objectMapper.convertValue(subscriberAddedEventOutputMap,SubscriberAddedEvent.class);
            log.debug("subscriberAddedEventOutput: " + subscriberAddedEventOutput);
         }
        else{
            log.debug("No subscriberAddedEvent variable exists");
        }
       HistoricVariableInstance destinationsVariable = processEngine.getHistoryService().createHistoricVariableInstanceQuery()
                .executionIdIn(processInstance.getId()).variableName("destinations").singleResult();
        if (destinationsVariable!=null){
            destinations = (List<Destination>) destinationsVariable.getValue();
            log.debug("destinations: " + destinations);
         }
        else{
            log.debug("No destinations variable exists");
        }
        log.info("Destinations added {} for subscriber {}.", destinations, subscriberAddedEvent);
        return destinations;
    }


}
