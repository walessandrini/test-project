package com.cisco.service;

import com.cisco.model.*;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class EstablishPlanToOfferDelegate implements JavaDelegate {
    private static List<Plan> plans = List.of(new Plan(1, 3072), new Plan(2, 5120), new Plan(3, 10240), new Plan(4, 20480));

    public List<Plan> getPlans(){
        return plans;
    }

    public Plan getPlan(Integer id){
        return plans.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void execute(DelegateExecution execution){
        log.info("Establishing plan to offer...");
        Plan planToOffer=null;
        SubscriberData subscriberData = (SubscriberData) execution.getVariable("subscriberAddedEvent");
        Plan currentPlan = this.getPlan(subscriberData.getPlanId());
        Integer elapsedDays = Period.between(subscriberData.getPlanRenewalDate(),  LocalDate.now()).getDays();//Days from last plan renewal
        if (elapsedDays == 0){
            planToOffer= this.getPlans().stream().max(Comparator.comparing(Plan::getDataMb)).orElse(null);
        }
        else{
            Integer mbRemaining = currentPlan.getDataMb() - subscriberData.getDataUsageMb();
            Integer remainingDays = 30 - elapsedDays;
            Integer minimumMbToOffer = ((remainingDays * subscriberData.getDataUsageMb()) / elapsedDays) - mbRemaining;
            Optional<Plan> planToOfferOpt=this.getPlans().stream().filter(p-> p.getDataMb() >= minimumMbToOffer).findFirst();
            if(planToOfferOpt.isEmpty()){
                planToOffer = this.getPlans().stream().max(Comparator.comparing(Plan::getDataMb)).orElse(null);
            }
            else{
                planToOffer = planToOfferOpt.orElse(null);
            }
        }
        execution.setVariable("planToOffer", planToOffer);
        log.debug("Setting plan to Offer: {} ", planToOffer);
    }
}
