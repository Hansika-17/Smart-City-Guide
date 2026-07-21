package com.smartcity.smartcityguide.recommendation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationResult {

    private Itinerary itinerary;

    private Integer compatibilityScore;

    private String explanation;

}
