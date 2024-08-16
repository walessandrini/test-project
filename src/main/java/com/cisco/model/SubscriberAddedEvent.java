package com.cisco.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.google.common.base.Preconditions;
//import com.threeci.tfbis.service.notifier.ExternalSystemNotifier;
//import java.util.Map;

/** Generated when there is no prior version of this subscriber in the database. */
@JsonDeserialize(using = SubscriberAddedEventDeserializer.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberAddedEvent extends Event {

  private Subscriber newSubscriber;

  public SubscriberAddedEvent(Builder builder) {
    this.createdOn = builder.createdOn;
    this.newSubscriber = builder.newSubscriber;
  }

  public static Builder builder() {
    return new Builder();
  }

  public Subscriber getNewSubscriber() {
    return newSubscriber;
  }

//  @Override
//  public void acceptNotifier(ExternalSystemNotifier notifier, Destination destination) {
//    notifier.sendNotification(this, destination);
//  }

  @Override
  public String toString() {
    return "SubscriberAddedEvent{" +
        "newSubscriber=" + newSubscriber +
        ", createdOn=" + createdOn +
        "}";
  }

  /** Builder. */
  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
  public static class Builder extends Event.Builder<Builder> {

    private Subscriber newSubscriber;

    public Builder withNewSubscriber(Subscriber newSubscriber) {
      this.newSubscriber = newSubscriber;
      return this;
    }

    public SubscriberAddedEvent build() {
      validate();
      return new SubscriberAddedEvent(this);
    }

    @Override
    public void validate() {
//      Preconditions.checkNotNull(newSubscriber);
    }
  }
}
