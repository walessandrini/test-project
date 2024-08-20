package com.cisco.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrier {

  /** The actual carrier name i.e.: AT&T. */
  private String name;

  /** The carrier abbreviation used by SPR to refer to the carrier. */
  private String abbreviation;

  /**
   * The list of different aliases used by external systems to refer to this carrier.
   *
   * <p>New aliases can't be added or removed from this list. To change the values the list has to
   * be replaced by a new one.
   */
  private Set<String> aliases = Collections.emptySet();


}
