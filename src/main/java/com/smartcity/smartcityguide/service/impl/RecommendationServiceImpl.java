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
            hotelRepository.findByCity(request.getCity());
            // Filter hotels based on selected budget
if (request.getPriceRange() != null && !request.getPriceRange().isBlank()) {

    String budget = request.getPriceRange().toLowerCase();

    hotels.removeIf(hotel -> {

        if (hotel.getPriceRange() == null) {
            return true;
        }

        String price = hotel.getPriceRange().toLowerCase();

        switch (budget) {

    case "budget":
        // No budget hotels in DB, so recommend Premium hotels
        return !price.contains("premium");

    case "mid-range":
        // Recommend Premium and Luxury
        return !(price.contains("premium") || price.contains("luxury"));

    case "luxury":
        // Only Luxury hotels
        return !price.contains("luxury");

    default:
        return false;
}
    });
}

        List<Restaurant> restaurants =
            restaurantRepository.findByCity(request.getCity());
            // Filter restaurants based on selected budget
if (request.getPriceRange() != null && !request.getPriceRange().isBlank()) {

    String budget = request.getPriceRange().toLowerCase();

    restaurants.removeIf(restaurant -> {

        if (restaurant.getPriceRange() == null) {
            return true;
        }

        String price = restaurant.getPriceRange().toLowerCase();

        switch (budget) {

            case "budget":
                return price.contains("premium");

            case "mid-range":
                return false;

            case "luxury":
                return !price.contains("premium");

            default:
                return false;
        }
    });
}

        List<Attraction> attractions =
                attractionRepository.findByCity(request.getCity());

        List<Event> events =
                eventRepository.findByCity(request.getCity());


        // Filter using bestFor
if (request.getBestFor() != null && !request.getBestFor().isBlank()) {

    hotels.removeIf(hotel ->
            !matchesBestFor(hotel.getBestFor(), request.getBestFor()));

    restaurants.removeIf(restaurant ->
            !matchesBestFor(restaurant.getBestFor(), request.getBestFor()));

    attractions.removeIf(attraction ->
            !matchesBestFor(attraction.getBestFor(), request.getBestFor()));

    events.removeIf(event ->
            !matchesBestFor(event.getBestFor(), request.getBestFor()));
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
     
    System.out.println("Hotels: " + hotels.size());
    System.out.println("Restaurants: " + restaurants.size());
    System.out.println("Attractions: " + attractions.size());
    System.out.println("Events: " + events.size());

    // Surprise Me
if (request.isSurpriseMe()) {

    Collections.shuffle(hotels);
    Collections.shuffle(restaurants);
    Collections.shuffle(attractions);
    Collections.shuffle(events);

    if (hotels.size() > 1) {
        hotels = hotels.subList(0, 1);
    }

    if (restaurants.size() > 2) {
        restaurants = restaurants.subList(0, 2);
    }

    if (attractions.size() > 2) {
        attractions = attractions.subList(0, 2);
    }

    if (events.size() > 2) {
        events = events.subList(0, 2);
    }
}


// Set response data
response.setHotels(hotels);
response.setRestaurants(restaurants);
response.setAttractions(attractions);
response.setEvents(events);    

return response;
}

// ADD THIS METHOD HERE

private List<String> getPersonaKeywords(String persona) {

    if (persona == null) {
        return Collections.emptyList();
    }

    switch (persona.toLowerCase()) {

        case "foodie":
            return List.of(
                    "foodie",
                    "food",
                    "local cuisine",
                    "restaurant",
                    "street food"
            );

        case "history lover":
            return List.of(
                    "history buff",
                    "history",
                    "heritage",
                    "museum",
                    "fort"
            );

        case "influencer":
            return List.of(
                    "photography",
                    "influencer",
                    "instagram",
                    "scenic"
            );

        case "nature explorer":
            return List.of(
                    "nature",
                    "park",
                    "lake",
                    "wildlife"
            );

        case "business traveller":
            return List.of(
                    "business traveller",
                    "business"
            );

        case "student":
            return List.of(
                    "student"
            );

        case "family":
            return List.of(
                    "family"
            );

        case "couple":
            return List.of(
                    "couple"
            );

        case "friends":
            return List.of(
                    "friends"
            );

        default:
            return List.of(persona.toLowerCase());
    }
}

private boolean matchesBestFor(String databaseValue, String selectedPersona) {

    if (databaseValue == null || selectedPersona == null) {
        return false;
    }

    String dbValue = databaseValue.toLowerCase();

    for (String keyword : getPersonaKeywords(selectedPersona)) {
        if (dbValue.contains(keyword.toLowerCase())) {
            return true;
        }
    }

    return false;
}

}