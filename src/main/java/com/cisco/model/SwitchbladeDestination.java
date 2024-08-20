package com.cisco.model;

//import static com.google.common.base.Strings.isNullOrEmpty;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Configures a destination to a workflow initiator switchblade campaign. */
@JsonDeserialize
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

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

}
