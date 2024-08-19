package com.cisco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer implements Serializable{
    private LocalDate timeToLive;
    private LocalDate futureTimeToLive;
}
