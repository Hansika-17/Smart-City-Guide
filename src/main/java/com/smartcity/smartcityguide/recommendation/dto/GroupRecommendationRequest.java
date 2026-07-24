package com.smartcity.smartcityguide.recommendation.dto;

import com.smartcity.smartcityguide.recommendation.model.GroupMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRecommendationRequest {

    private List<GroupMember> members;

}
