package com.smartcity.smartcityguide.dto;

import com.smartcity.smartcityguide.entity.Attraction;
import com.smartcity.smartcityguide.entity.Event;
import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.entity.Restaurant;
import lombok.Data;

import java.util.List;

@Data
public class RecommendationResponse {

    private List<Hotel> hotels;

    private List<Restaurant> restaurants;

    private List<Attraction> attractions;

    private List<Event> events;
}