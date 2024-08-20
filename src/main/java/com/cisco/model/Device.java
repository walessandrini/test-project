package com.cisco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {


  public static final Pattern ESN_RE = Pattern.compile("^[0-9]+$");
  public static final Pattern MAC_ADDRESS_RE = Pattern.compile("\\S+");

  /** The device id. */
  String id;

  /** The device electronic serial number. */
  String esn;

  /** The device unique MAC address. */
  String macAddress;

  /** The device manufacturer id. */
  String manufacturerId;

  /** The device model id. */
  String modelId;

  /** The device toolkit. */
 String toolkit;


}
