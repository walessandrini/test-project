package com.cisco.service;

import com.cisco.model.Plan;
import com.cisco.model.SubscriberData;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SubscriberDataService {
    private final static String ESTABILSH_PLAN_TO_OFFER_PROCESS = "establish_plan_to_offer";

    public Plan establishPlanToOffer(SubscriberData subscriberData) {
        return this.invokeBusinessProcess(subscriberData);
    }

    private Plan invokeBusinessProcess(SubscriberData subscriberData) {
        // Define process variables if needed
        Plan planToOffer = new Plan();
        Map<String, Object> variables = new HashMap<>();
        variables.put("subscriberData", subscriberData);
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // Get the RuntimeService from the process engine
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // Start the process instance by process definition key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(ESTABILSH_PLAN_TO_OFFER_PROCESS, variables);
        // Output the process instance ID
        log.info("Started process instance with ID: " + processInstance.getId());
        HistoricVariableInstance subscriberDataVariable = processEngine.getHistoryService().createHistoricVariableInstanceQuery()
                .executionIdIn(processInstance.getId()).variableName("subscriberData").singleResult();
        SubscriberData subscriberDataOutput;
        if (subscriberDataVariable!=null){
            subscriberDataOutput = (SubscriberData) subscriberDataVariable.getValue();
            log.debug("subscriberDataOutput: " + subscriberDataOutput);
         }
        else{
            log.debug("No subscriberData variable exists");
        }
       HistoricVariableInstance planToOfferVariable = processEngine.getHistoryService().createHistoricVariableInstanceQuery()
                .executionIdIn(processInstance.getId()).variableName("planToOffer").singleResult();
        if (planToOfferVariable!=null){
            planToOffer = (Plan) planToOfferVariable.getValue();
            log.debug("plan to offer: " + planToOffer);
         }
        else{
            log.debug("No plan to offer variable exists");
        }
//        log.info("Destinations added {} for subscriber {}.", destinations, subscriberAddedEvent);
        return planToOffer;
    }


}
