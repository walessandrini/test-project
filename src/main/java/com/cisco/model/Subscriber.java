package com.cisco.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

@JsonDeserialize(using = SubscriberDeserializer.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber implements Serializable {

    private String brandId;
    private Offer newOffer;

    @Override
    public String toString() {
        return "Subscriber: {" +
                "brandId:" + brandId +
                ", newOffer: " + newOffer +
                "}";
    }

}
