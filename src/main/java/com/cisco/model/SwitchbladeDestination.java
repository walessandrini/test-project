package com.cisco.model;

//import static com.google.common.base.Strings.isNullOrEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
//import com.google.common.collect.ImmutableMap;
//import com.threeci.tf.messaging.producer.MessageSenderService;
//import com.threeci.tfbis.service.messageprocessor.MessageSenderResolver;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Configures a destination to a workflow initiator switchblade campaign. */
@JsonDeserialize(builder = SwitchbladeDestination.Builder.class)
public class SwitchbladeDestination extends Destination {

  public static final String TRIGGER_ID = "trigger_id";
  public static final String CLIENT_TAG = "client_tag";
  public static final String SHORT_CODE = "short_code";
  public static final String COUNTRY_CODE = "country_code";

  private String triggerId;
  private String clientTag;
  private String shortCode;
  private String countryCode;
  private Map<String, String> extraParams;

  private SwitchbladeDestination(Builder builder) {
    super();
    this.triggerId = builder.triggerId;
    this.clientTag = builder.clientTag;
    this.shortCode = builder.shortCode;
    this.extraParams = builder.extraParams;
    this.countryCode = builder.countryCode;
//    ImmutableMap.Builder<String, String> mapBuilder
//        = ImmutableMap.<String, String>builder();
    
//    mapBuilder.put(TRIGGER_ID, builder.triggerId)
//    .put(CLIENT_TAG, builder.clientTag)
//    .put(SHORT_CODE, builder.shortCode)
//    .putAll(builder.extraParams);
    
//    Optional.ofNullable(builder.countryCode)
//            .ifPresent(x -> mapBuilder.put(COUNTRY_CODE, x));
//
//    super.setParams(mapBuilder.build());
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getTriggerId() {
    return triggerId;
  }

  public String getClientTag() {
    return clientTag;
  }

  public String getShortCode() {
    return shortCode;
  }

  public Optional<String> getCountryCode() {
    return Optional.ofNullable(countryCode);
  }

  public Map<String, String> getExtraParams() {
    return extraParams;
  }

//  @Override
//  public MessageSenderService<OutgoingMessage> getMsgSender(MessageSenderResolver rkResolver) {
//    return rkResolver.getSender(this);
//  }

  /** SwitchbladeDestination builder. */
  @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
  public static class Builder {

    private String triggerId;
    private String clientTag = "";
    private String shortCode = "";
    private String countryCode;
    private Map<String, String> extraParams = new HashMap<>();

    public Builder withTriggerId(String triggerId) {
      this.triggerId = triggerId;
      return this;
    }

    public Builder withClientTag(String clientTag) {
      this.clientTag = clientTag;
      return this;
    }

    public Builder withShortCode(String shortCode) {
      this.shortCode = shortCode;
      return this;
    }

    public Builder withCountryCode(String countryCode) {
      this.countryCode = countryCode;
      return this;
    }

    public Builder withExtraParams(Map<String, String> extraParams) {
      this.extraParams = extraParams;
      return this;
    }

    public Builder withExtraParam(String key, String value) {
      this.extraParams.put(key, value);
      return this;
    }

    public SwitchbladeDestination build() {
      validate();
      return new SwitchbladeDestination(this);
    }

    private void validate() {
//      if (isNullOrEmpty(triggerId)) {
//        throw new IllegalArgumentException("triggerId is required.");
//      }
    }
  }
}
