package com.cisco.service;

import com.cisco.model.SubscriberAddedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Component
@Slf4j
public class NotificationsAllowedDelegate implements JavaDelegate {
    private final static String BASE_URL = "https://api.restful-api.dev/objects" ;
    @Override
    public void execute(DelegateExecution execution){
        Boolean subscriberAllowsNotifications;
        SubscriberAddedEvent subscriberAddedEvent = (SubscriberAddedEvent) execution.getVariable("subscriberAddedEvent");
        Map<String, Object> response =this.invokeApi(subscriberAddedEvent);
        subscriberAllowsNotifications = ((String)response.get("name")).contains("Apple");
        log.info("Does the new subscriber {} allow Notifications: {}", subscriberAddedEvent.getNewSubscriber().getMdn(), subscriberAllowsNotifications);
        execution.setVariable("subscriberAllowsNotifications", subscriberAllowsNotifications);
    }

    private Map<String, Object> invokeApi(SubscriberAddedEvent subscriberAddedEvent) {
        RestClient defaultClient = RestClient.create();
        Integer id = this.getId(subscriberAddedEvent);
        String response = defaultClient.get().uri(BASE_URL+"/{id}", id).retrieve().body(String.class);
        Map<String, Object> map;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(response, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    private Integer getId(SubscriberAddedEvent subscriberAddedEvent) {
       String initChar=subscriberAddedEvent.getNewSubscriber().getMdn().substring(0,1);
       return !initChar.equals("0") ? Integer.parseInt(initChar) : 10;
    }
}
