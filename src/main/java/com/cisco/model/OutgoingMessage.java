package com.cisco.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.threeci.tf.messaging.model.Payload;

/**
 * An OutgoingMessage message consists in any Event subclass and a list of destinations to forward
 * that event to.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "@class")
public class OutgoingMessage{ //extends Payload {

  private Destination destination;
  private Event event;

  public OutgoingMessage() {}

  public OutgoingMessage(Destination destination, Event event) {
    this.destination = destination;
    this.event = event;
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  @Override
  public String toString() {
    return "OutgoingMessage{" + "destination=" + destination + ", event=" + event + '}';
  }

}
