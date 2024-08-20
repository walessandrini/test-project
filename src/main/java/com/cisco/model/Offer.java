package com.cisco.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class Offer<A extends Offer<?>> {

  /** The unique identifier. */
  String id;

  /** The date on which the offer was redeemed. */
  LocalDate redemptionDate;

  /** The last date on which the offer is valid. */
  LocalDate timeToLive;

}
