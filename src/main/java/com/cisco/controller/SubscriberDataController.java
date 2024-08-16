package com.cisco.controller;

import com.cisco.model.Destination;
import com.cisco.model.Plan;
import com.cisco.model.SubscriberAddedEvent;
import com.cisco.model.SubscriberData;
import com.cisco.service.SubscriberDataService;
import com.cisco.service.SubscriberEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscriberData")
public class SubscriberDataController {

     @Autowired
     private SubscriberDataService subscriberDataService;

    @PostMapping("/")
    public Plan establishPlanToOffer(@RequestBody(required = true) SubscriberData subscriberData){
        return subscriberDataService.establishPlanToOffer(subscriberData);
    }
}
