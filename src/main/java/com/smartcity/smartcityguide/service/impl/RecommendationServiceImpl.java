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
import com.smartcity.smartcityguide.entity.Attraction;
import com.smartcity.smartcityguide.entity.Event;
import com.smartcity.smartcityguide.repository.AttractionRepository;
import com.smartcity.smartcityguide.repository.EventRepository;

import java.util.Collections;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AttractionRepository attractionRepository;

    @Autowired
    private EventRepository eventRepository;

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

        List<Attraction> attractions =
                attractionRepository.findByCity(request.getCity());

        List<Event> events =
                eventRepository.findByCity(request.getCity());


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

     attractions.removeIf(attraction ->
        attraction.getBestFor() == null ||
        !attraction.getBestFor().toLowerCase()
                .contains(request.getBestFor().toLowerCase()));

     events.removeIf(event ->
        event.getBestFor() == null ||
        !event.getBestFor().toLowerCase()
                .contains(request.getBestFor().toLowerCase()));
}

// Filter using timeAvailable
if (request.getTimeAvailable() != null && !request.getTimeAvailable().isBlank()) {

    String userTime = request.getTimeAvailable().toLowerCase();

    attractions.removeIf(attraction -> {

        if (attraction.getTimeRequired() == null) {
            return true;
        }

        String attractionTime = attraction.getTimeRequired().toLowerCase();

        switch (userTime) {

            case "1 hour":
                return !(attractionTime.equals("1 hour"));

            case "1-2 hours":
                return !(attractionTime.equals("1 hour")
                        || attractionTime.equals("1-2 hours"));

            case "2 hours":
                return !(attractionTime.equals("1 hour")
                        || attractionTime.equals("1-2 hours")
                        || attractionTime.equals("2 hours"));

            case "2-3 hours":
                return !(attractionTime.equals("1 hour")
                        || attractionTime.equals("1-2 hours")
                        || attractionTime.equals("2 hours")
                        || attractionTime.equals("2-3 hours"));

            case "3 hours":
                return !(attractionTime.equals("3 hours"));

            case "3-4 hours":
                return !(attractionTime.equals("3 hours")
                        || attractionTime.equals("3-4 hours"));

            case "4-5 hours":
                return !(attractionTime.equals("4-5 hours"));

            case "half day":
                return attractionTime.equals("full day");

            case "full day":
                return false;

            default:
                return false;
        }
    });
}

// Filter using transport
if (request.getTransport() != null && !request.getTransport().isBlank()) {

    String transport = request.getTransport().toLowerCase();

    attractions.removeIf(attraction -> {

        if (attraction.getTimeRequired() == null) {
            return true;
        }

        String attractionTime = attraction.getTimeRequired().toLowerCase();

        switch (transport) {

            case "walking":
                return attractionTime.contains("3")
                        || attractionTime.contains("4")
                        || attractionTime.contains("full");

            case "bike":
                return attractionTime.contains("full");

            case "car":
                return false;

            default:
                return false;
        }
    });
}

        // Surprise Me
        if (request.isSurpriseMe()) {

    Collections.shuffle(hotels);
    Collections.shuffle(restaurants);
    Collections.shuffle(attractions);
    Collections.shuffle(events);

    if (hotels.size() > 1) {
        hotels = hotels.subList(0, 1);
    }

    if (restaurants.size() > 1) {
        restaurants = restaurants.subList(0, 1);
    }

    if (attractions.size() > 2) {
        attractions = attractions.subList(0, 2);
    }

    if (events.size() > 1) {
        events = events.subList(0, 1);
    }
}
response.setHotels(hotels);
response.setRestaurants(restaurants);
response.setAttractions(attractions);
response.setEvents(events);

return response;
}
}