package com.cisco.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
//import com.google.common.collect.ImmutableMap;
//import com.threeci.tf.messaging.producer.MessageSenderService;
//import com.threeci.tfbis.service.messageprocessor.MessageSenderResolver;
import java.util.HashMap;
import java.util.Map;

/** Send messages to the Logging queue. */
@JsonDeserialize
@Builder
@Data
public class LogDestination extends Destination {

  private Map<String, String> extraParams;

//  private LogDestination(Builder builder) {
//    this.extraParams = builder.extraParams;
//    super.setParams(ImmutableMap.<String, String>builder().putAll(builder.extraParams).build());
//  }

//  public static Builder builder() {
//    return new Builder();
//  }

//  @Override
//  public MessageSenderService<OutgoingMessage> getMsgSender(MessageSenderResolver rkResolver) {
//    return rkResolver.getSender(this);
//  }

//  public Map<String, String> getExtraParams() {
//    return extraParams;
//  }

  /** LogDestination builder. */
//  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
//  public static class Builder {
//
//    private Map<String, String> extraParams = new HashMap<>();
//
//    public Builder withExtraParams(Map<String, String> extraParams) {
//      this.extraParams = extraParams;
//      return this;
//    }
//
//    public Builder withTag(String key, String value) {
//      this.extraParams.put(key, value);
//      return this;
//    }
//
//    public LogDestination build() {
//      return new LogDestination(this);
//    }
//  }
}
