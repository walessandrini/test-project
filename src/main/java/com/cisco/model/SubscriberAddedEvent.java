package com.cisco.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/** Generated when there is no prior version of this subscriber in the database. */
//@JsonDeserialize(using = SubscriberAddedEventDeserializer.class)
@JsonDeserialize
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberAddedEvent extends Event {

  private Subscriber newSubscriber;

  public Subscriber getNewSubscriber() {
    return newSubscriber;
  }


//  @Override
//  public String toString() {
//    return "SubscriberAddedEvent{" +
//        "newSubscriber=" + newSubscriber +
//        ", createdOn=" + createdOn +
//        "}";
//  }

}
