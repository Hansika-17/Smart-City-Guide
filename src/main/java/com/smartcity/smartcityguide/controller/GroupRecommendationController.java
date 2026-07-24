package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.dto.GroupRecommendationRequest;
import com.smartcity.smartcityguide.dto.GroupRecommendationResponse;
import com.smartcity.smartcityguide.service.GroupRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/group-recommendations")
@CrossOrigin(origins = "*")
public class GroupRecommendationController {

    @Autowired
    private GroupRecommendationService groupRecommendationService;

    @PostMapping
    public ResponseEntity<GroupRecommendationResponse> getGroupRecommendation(
            @RequestBody GroupRecommendationRequest request) {

        GroupRecommendationResponse response =
                groupRecommendationService.getGroupRecommendation(request);

        return ResponseEntity.ok(response);
    }
}