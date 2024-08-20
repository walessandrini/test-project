package com.cisco.model;

import lombok.Builder;
import lombok.Data;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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

}
