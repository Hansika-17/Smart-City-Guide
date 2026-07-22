package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.dto.RecommendationRequest;
import com.smartcity.smartcityguide.dto.RecommendationResponse;
import com.smartcity.smartcityguide.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "*")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<RecommendationResponse> getRecommendations(
            @RequestBody RecommendationRequest request) {

        RecommendationResponse response =
                recommendationService.getRecommendations(request);

        return ResponseEntity.ok(response);
    }
}