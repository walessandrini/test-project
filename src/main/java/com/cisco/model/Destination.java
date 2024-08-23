package com.cisco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents a 3rd party destination. It includes the name of the system and the required
 * parameters to configure the client.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "@class")
@JsonSubTypes({
    @Type(value = HttpDestination.class, name = "HttpDestination"),
    @Type(value = LogDestination.class, name = "LogDestination"),
    @Type(value = SwitchbladeDestination.class, name = "SwitchbladeDestination")
})
@Data
@NoArgsConstructor
public abstract class Destination implements Serializable {

  @JsonIgnore private Map<String, String> params;


}
