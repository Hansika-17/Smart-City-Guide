package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.dto.RecommendationRequest;
import com.smartcity.smartcityguide.dto.RecommendationResponse;

public interface RecommendationService {

    RecommendationResponse getRecommendations(RecommendationRequest request);

}