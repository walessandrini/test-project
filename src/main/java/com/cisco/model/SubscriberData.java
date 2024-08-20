package com.cisco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spinjar.com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonDeserialize
public class SubscriberData implements Serializable {

    private Long id;
    private Integer dataUsageMb;
    private Integer dataRemainingMB;
    private Integer planId;
    private LocalDate planRenewalDate;//Date when the plan was renewed
}
