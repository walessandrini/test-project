package com.cisco.controller;

import com.cisco.model.Destination;
import com.cisco.model.SubscriberAddedEvent;
import com.cisco.service.SubscriberEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscriberEvent")
public class SubscriberEventController {

     @Autowired
     private SubscriberEventService subscriberEventService;

    @PostMapping("/")
    public List<Destination> subscriberAddedEvent(@RequestBody(required = true) SubscriberAddedEvent subscriberAddedEvent){
        return subscriberEventService.subscriberAdded(subscriberAddedEvent);
    }
}
