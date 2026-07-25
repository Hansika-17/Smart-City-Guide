package com.smartcity.smartcityguide.service;

import com.smartcity.smartcityguide.dto.GroupRecommendationRequest;
import com.smartcity.smartcityguide.dto.GroupRecommendationResponse;

public interface GroupRecommendationService {

    GroupRecommendationResponse getGroupRecommendation(
            GroupRecommendationRequest request);

}