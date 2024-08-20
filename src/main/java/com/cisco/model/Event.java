package com.cisco.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * The <code>Event</code> type helps identify events that can be sent to external systems. An
 * acceptNotifier method is provided to let 3rd party notifiers outgoing message
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "@class")
@JsonSubTypes({
    @Type(value = SubscriberAddedEvent.class, name = "SubscriberAddedEvent"),
//    @Type(value = SubscriberDeletedEvent.class, name = "SubscriberDeletedEvent"),
//    @Type(value = SubscriberUpdatedEvent.class, name = "SubscriberUpdatedEvent"),
//    @Type(value = SubscriberMismatchIndexEvent.class, name = "SubscriberMismatchIndexEvent")
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public abstract class Event implements Serializable {

  // Time of the update that generated this event
  protected String createdOn;

}
