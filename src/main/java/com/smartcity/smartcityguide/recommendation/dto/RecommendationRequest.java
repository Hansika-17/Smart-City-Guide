package com.smartcity.smartcityguide.recommendation.dto;

import com.smartcity.smartcityguide.recommendation.enums.BudgetType;
import com.smartcity.smartcityguide.recommendation.enums.TimeAvailable;
import com.smartcity.smartcityguide.recommendation.enums.TransportMode;
import com.smartcity.smartcityguide.recommendation.enums.TravelPersona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecommendationRequest {

    private String city;

    private BudgetType budget;

    private TravelPersona persona;

    private TimeAvailable timeAvailable;

    private TransportMode transportMode;

}
