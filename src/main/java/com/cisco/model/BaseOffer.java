package com.cisco.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseOffer extends Offer<BaseOffer> {

  /** The future time to live. */
  private LocalDate futureTimeToLive;


}
