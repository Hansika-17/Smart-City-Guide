package com.smartcity.smartcityguide.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupRecommendationRequest {

    private String city;

    private List<GroupMemberRequest> members;

    private boolean surpriseMe;

}