package com.cisco.model;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@Data
public abstract class Account<A extends Account<?>> {

    /** The unique instance identifier. */
  String id;
  /**
   * The current <em>base</em> offer determining the instance's status.
   *
   * <p>
   *
   * <p>At any given time an instance must have only one outstanding base offer. The offer's
   * time-to-live determines the instance's status.
   */
  BaseOffer baseOffer;
  /**
   * The list of <em>add-on</em> offers associated with the instance.
   *
   * <p>
   *
   * <p>An instance may have zero or more add-on offers that specify additional mobile services and
   * quotas available through a time-to-live.
   *
   * <p>This is a read-only list: once set elements cannot be added to or removed from it. It can
   * only be replaced by a new list.
   */
  List<AddOnOffer> addOnOffers = Collections.emptyList();

  public static final Pattern ID_RE = Pattern.compile("^[A-Za-z0-9-]+$");


}
