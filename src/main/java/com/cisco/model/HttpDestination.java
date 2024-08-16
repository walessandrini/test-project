package com.cisco.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.google.common.collect.ImmutableMap;
//import com.threeci.tf.messaging.producer.MessageSenderService;
//import com.threeci.tfbis.service.messageprocessor.MessageSenderResolver;
import java.util.HashMap;
import java.util.Map;

/**
 * A destination that will propagate the event to a 3rd party over HTTP.
 *
 * <p>extraParams: is a map with metadata that can be set in the rule definition and will be passed
 * back to the post-back server under the metadata key. See:
 * https://3cinteractive.atlassian.net/wiki/spaces/SPR/pages/728596756/TFBIS?preview=/728596756/728400108/subscriber_updated.json
 *
 * <p>target: this is the actual http target to send the event to, available targets are configured
 * in the application.yml and the target property configured on this instance must match the name of
 * one of the targets configured in the application.yml
 */
@JsonDeserialize
@Builder
@Data
public class HttpDestination extends Destination {

  private Map<String, String> extraParams;
  private String target;

//  public HttpDestination(Builder builder) {
//    this.extraParams = builder.extraParams;
//    this.target = builder.target;
//    super.setParams(this.extraParams);
////    super.setParams(ImmutableMap.<String, String>builder().putAll(builder.extraParams).build());
//  }


//  public static Builder builder() {
//    return new Builder();
//  }

  /**
   * Returns the routing key for RabbitMq destination.
   *
   * @param rkResolver
   * @return
   */
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
//    private Map<String, String> extraParams = new HashMap<>();
//    private String target;
//
//    public Builder withExtraParams(Map<String, String> extraParams) {
//      this.extraParams = extraParams;
//      return this;
//    }
//
//    public Builder withTarget(String target) {
//      this.target = target;
//      return this;
//    }
//
//    public Builder withMetadata(String key, String value) {
//      this.extraParams.put(key, value);
//      return this;
//    }
//
//    public HttpDestination build() {
//      return new HttpDestination(this);
//    }
//  }
}
