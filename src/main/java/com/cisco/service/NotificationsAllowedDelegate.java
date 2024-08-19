package com.cisco.service;

import com.cisco.model.SubscriberAddedEvent;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotificationsAllowedDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution){
        Boolean subscriberAllowsNotifications = true;
        SubscriberAddedEvent subscriberAddedEvent = (SubscriberAddedEvent) execution.getVariable("subscriberAddedEvent");
        execution.setVariable("subscriberAllowsNotifications", subscriberAllowsNotifications);
    }
}
