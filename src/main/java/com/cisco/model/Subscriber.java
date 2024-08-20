package com.cisco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@JsonDeserialize(using = SubscriberDeserializer.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber extends Account<Subscriber> implements Serializable {

    public enum Status {
        ACTIVE,
        INACTIVE
    }

    private Status status;
    private String brandId;
    private Long dealerId;
    private Long contactObjectId;
    private Long webUserObjectId;
    /**
     * The group identifier if the subscriber belongs to a group. <code>Null</code> for individual
     * subscribers not affiliated with a group.
     */
    private String groupId = "";

    /** The {@link Device} currently associated with the subscriber. */
    private Device device;

    /** The mobile directory number currently associated with the subscriber. */
    private String mdn;

    /** The carrier-supplied mobile identification number. */
    private String min;
    /**
     * The conversion factor used to determine how minutes are deducted from accounts (e.g. buying
     * apps from a smart phone)
     *
     * <p>
     *
     * <p>TBD: The data type used here is <code>Double</code> where past versions used <code>String
     * </code>.
     */
    private Double conversionFactor;

    /**
     * The 3rd-party vendor denomination.
     *
     * <p>
     *
     * <p>TBD: Further clarification needed
     */
    private String denomination;
    /**
     * The carrier actually supplying communication service to the subscriber.
     *
     * <p>
     *
     * <p>Carriers may operate under different subdivisions. This property always refers to the
     * top-level, "parent" carrier.
     */
    private String parentCarrier;

    /** The transaction identifier. */
    private String transactionId;

    /**
     * The identifier for the subscriber's current rate plan.
     *
     * <p>
     *
     * <p>
     */
    private String ratePlanId;
    /**
     * The identifier for the subscriber's current service plan.
     *
     * <p>
     *
     * <p>
     */
    private Long servicePlanId;

    /**
     * The description of the subscriber's current service plan.
     *
     * <p>
     *
     * <p>
     */
    private String servicePlanDescription;

    /** Subscriber language. */
    private String language = "";

    /** International mobile subscriber identity. Should have more than 9 digits. */
    private String imsi = "";

    /** US zipCode. */
    private String zipCode = "";

    /** Date the subscriber first activated the line. */
    private LocalDate activationDate ;

    /** Safelink flag. */
    private String safelinkFlag = "";

    /** Safelink certification flag. */
    private String safelinkCertificationFlag = "";

    /** autorefill flag. */
    private String autoRefillFlag = "";

    /**
     * Metadata - freeform string,value pairs that can be used, if needed. key limited to [0-9a-zA-Z]
     * characters value limited to [0-9a-zA-Z- ]
     */
    private Map<String, String> metadata = Map.of();

    /** rcsCapable RCS capability indication string field. Current valid values are Y and N. */
    private String rcsCapable;

    private String posa = "";

    private String iccid = "";

    private String unlockedPhone = "";

//    @Override
//    public String toString() {
//        return "Subscriber: {" +
//                "brandId:" + brandId +
//                ", newOffer: " + baseOffer +
//                "}";
//    }

}
