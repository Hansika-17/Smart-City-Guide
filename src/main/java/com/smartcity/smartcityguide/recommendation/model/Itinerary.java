package com.smartcity.smartcityguide.recommendation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Itinerary {

    private String hotel;

    private String restaurant;

    private String attraction;

    private String event;

    private String explanation;

}
