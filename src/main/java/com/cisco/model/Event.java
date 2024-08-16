package com.cisco.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.threeci.tfbis.service.notifier.ExternalSystemNotifier;
//import com.threeci.tfbis.service.notifier.NotificationException;
//import java.time.Instant;
import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.Map;

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
public abstract class Event implements Serializable {

  // Time of the update that generated this event
  protected String createdOn;

  public Event() {
  }

//  public abstract void acceptNotifier(ExternalSystemNotifier notifier, Destination destination)
//      throws NotificationException;

  public String getCreatedOn() {
    return createdOn;
  }

  @Override
  public String toString() {
    return "Event{" + "createdOn=" + createdOn + + '}';
  }

  /**
   * Extendable Builder.
   *
   * @param <T>
   */
  public abstract static class Builder<T extends Builder<T>> {

    protected String createdOn;

    public Builder() {}

    public T withCreatedOn(String createdOn) {
      this.createdOn = createdOn;
      return (T) this;
    }

    public abstract void validate();
  }
}
