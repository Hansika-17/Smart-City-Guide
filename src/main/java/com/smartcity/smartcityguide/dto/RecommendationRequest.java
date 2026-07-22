package com.smartcity.smartcityguide.dto;

import lombok.Data;

@Data
public class RecommendationRequest {

    private String city;

    private String priceRange;

    private String bestFor;

    private String timeAvailable;

    private String transport;

    private boolean surpriseMe;
}