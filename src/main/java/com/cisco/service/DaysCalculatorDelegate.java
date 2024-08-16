package com.cisco.service;

import com.cisco.model.SubscriberData;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
@Slf4j
public class DaysCalculatorDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution){
        LocalDate now = LocalDate.now();
        SubscriberData subscriberData=(SubscriberData) execution.getVariable("subscriberData");
        Integer elapsedDays = Period.between(subscriberData.getPlanRenewalDate(),now).getDays();
        Integer remainingDays = 30 - elapsedDays;
        execution.setVariable("elapsedDays", elapsedDays);
        execution.setVariable("remainingDays", remainingDays);
        log.info("Remaining days {}", remainingDays);
    }

}
