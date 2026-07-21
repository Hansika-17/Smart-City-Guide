package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.recommendation.dto.GroupRecommendationRequest;
import com.smartcity.smartcityguide.recommendation.dto.RecommendationRequest;
import com.smartcity.smartcityguide.recommendation.engine.RecommendationEngine;
import com.smartcity.smartcityguide.recommendation.model.RecommendationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendation")
@CrossOrigin(origins = "*")
public class RecommendationController {

    @Autowired
    private RecommendationEngine recommendationEngine;

    // Solo Recommendation
    @PostMapping("/solo")
    public ResponseEntity<RecommendationResult> generateSoloRecommendation(
            @RequestBody RecommendationRequest request) {

        return ResponseEntity.ok(
                recommendationEngine.generateSoloItinerary(request)
        );
    }

    // Group Recommendation
    @PostMapping("/group")
    public ResponseEntity<RecommendationResult> generateGroupRecommendation(
            @RequestBody GroupRecommendationRequest request) {

        return ResponseEntity.ok(
                recommendationEngine.generateGroupItinerary(request)
        );
    }

    // Surprise Me
    @PostMapping("/surprise")
    public ResponseEntity<RecommendationResult> surpriseMe(
            @RequestBody RecommendationRequest request) {

        return ResponseEntity.ok(
                recommendationEngine.surpriseMe(request)
        );
    }

}