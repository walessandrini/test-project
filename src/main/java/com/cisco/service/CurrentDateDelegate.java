package com.cisco.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class CurrentDateDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution){
        LocalDate now = LocalDate.now();
        execution.setVariable("currentDate", now);
        log.debug("Setting current date {}", now);
    }

}
