package com.cisco.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

/** Send messages to the Logging queue. */
@JsonDeserialize
@Builder
@Data
public class LogDestination extends Destination {

  private Map<String, String> extraParams;

}
