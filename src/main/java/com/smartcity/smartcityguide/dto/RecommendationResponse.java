package com.smartcity.smartcityguide.dto;

import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.entity.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class RecommendationResponse {

    private List<Hotel> hotels;

    private List<Restaurant> restaurants;
}