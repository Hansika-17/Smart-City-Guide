package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.dto.RecommendationRequest;
import com.smartcity.smartcityguide.dto.RecommendationResponse;
import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.entity.Restaurant;
import com.smartcity.smartcityguide.repository.HotelRepository;
import com.smartcity.smartcityguide.repository.RestaurantRepository;
import com.smartcity.smartcityguide.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RecommendationResponse getRecommendations(RecommendationRequest request) {

        RecommendationResponse response = new RecommendationResponse();

        List<Hotel> hotels =
                hotelRepository.findByCityAndPriceRange(
                        request.getCity(),
                        request.getPriceRange());

        List<Restaurant> restaurants =
                restaurantRepository.findByCityAndPriceRange(
                        request.getCity(),
                        request.getPriceRange());


        // Filter using bestFor
if (request.getBestFor() != null && !request.getBestFor().isEmpty()) {

    hotels.removeIf(hotel ->
            hotel.getBestFor() == null ||
            !hotel.getBestFor().toLowerCase()
                    .contains(request.getBestFor().toLowerCase()));

    restaurants.removeIf(restaurant ->
            restaurant.getBestFor() == null ||
            !restaurant.getBestFor().toLowerCase()
                    .contains(request.getBestFor().toLowerCase()));
}

        // Surprise Me
        if (request.isSurpriseMe()) {
            Collections.shuffle(hotels);
            Collections.shuffle(restaurants);
        }

        response.setHotels(hotels);
        response.setRestaurants(restaurants);

        return response;
    }
}