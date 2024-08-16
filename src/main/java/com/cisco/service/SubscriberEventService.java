package com.cisco.service;

import com.cisco.model.Destination;
import com.cisco.model.SubscriberAddedEvent;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;
import spinjar.com.fasterxml.jackson.core.JsonProcessingException;
import spinjar.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SubscriberEventService {
    private static String GET_DESTINATIONS_PROCESS = "get_destinations";

    public List<Destination> subscriberAdded(SubscriberAddedEvent subscriberAddedEvent) {
        return this.invokeBusinessProcess(subscriberAddedEvent);
    }

    private List<Destination> invokeBusinessProcess(SubscriberAddedEvent subscriberAddedEvent) {
        // Define process variables if needed
        List<Destination> destinations = new ArrayList<>();
        Map<String, Object> variables = new HashMap<>();
        variables.put("subscriberAddedEvent", subscriberAddedEvent);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // Get the RuntimeService from the process engine
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // Start the process instance by process definition key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(GET_DESTINATIONS_PROCESS, variables);
        // Output the process instance ID
        log.debug("Started process instance with ID: " + processInstance.getId());
        HistoricVariableInstance subscriberAddedEventVariable = processEngine.getHistoryService().createHistoricVariableInstanceQuery()
                .executionIdIn(processInstance.getId()).variableName("subscriberAddedEvent").singleResult();
        SubscriberAddedEvent subscriberAddedEventOutput = null;
        if (subscriberAddedEventVariable!=null){
            subscriberAddedEventOutput = (SubscriberAddedEvent) subscriberAddedEventVariable.getValue();
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
