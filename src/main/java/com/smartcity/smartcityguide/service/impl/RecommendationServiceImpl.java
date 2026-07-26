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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Hotel,Integer> hotelScores = new HashMap<>();

for(Hotel hotel : hotels){


    int score = 0;

    score += calculatePersonaScore(
            hotel.getBestFor(),
            request.getBestFor());

    score += calculateBudgetScore(
            hotel.getPriceRange(),
            request.getPriceRange());

    score += calculateRatingScore(
            hotel.getRating());


    hotelScores.put(hotel,score);

} 
hotels.sort((h1,h2)->
    Integer.compare(hotelScores.get(h2),hotelScores.get(h1)));

    hotels = hotels.subList(
        0,
        Math.min(5, hotels.size())
);

    List<Restaurant> restaurants =
            restaurantRepository.findByCity(request.getCity());
    Map<Restaurant,Integer> restaurantScores=new HashMap<>();

for(Restaurant restaurant:restaurants){

    int score=0;

    score+=calculatePersonaScore(
        restaurant.getBestFor(),
        request.getBestFor());

    score+=calculateBudgetScore(
        restaurant.getPriceRange(),
        request.getPriceRange());

    score += calculateRatingScore(
        restaurant.getRating());    

    restaurantScores.put(restaurant,score);

}

restaurants.sort((r1,r2)->
    Integer.compare(restaurantScores.get(r2),restaurantScores.get(r1)));
    
    restaurants = restaurants.subList(
        0,
        Math.min(5, restaurants.size())
);
        
    List<Attraction> attractions =
                attractionRepository.findByCity(request.getCity());
    Map<Attraction,Integer> attractionScores=new HashMap<>();

for(Attraction attraction:attractions){

    int score=0;

    score+=calculatePersonaScore(
        attraction.getBestFor(),
        request.getBestFor());

    score+=calculateTimeScore(
        attraction.getTimeRequired(),
        request.getTimeAvailable());

    score+=calculateTransportScore(
        attraction.getTimeRequired(),
        request.getTransport());

    score += calculateRatingScore(attraction.getRating()); 
    

    attractionScores.put(attraction,score);

}

attractions.sort((a1,a2)->
Integer.compare(attractionScores.get(a2),attractionScores.get(a1)));

attractions = attractions.subList(
        0,
        Math.min(5, attractions.size())
);

        List<Event> events =
                eventRepository.findByCity(request.getCity());
        Map<Event,Integer> eventScores=new HashMap<>();

for(Event event:events){

    int score=0;

    score+=calculatePersonaScore(
        event.getBestFor(),
        request.getBestFor());

    eventScores.put(event,score);

}

events.sort((e1,e2)->
Integer.compare(eventScores.get(e2),eventScores.get(e1)));  

events = events.subList(
        0,
        Math.min(5, events.size())
);

    // Surprise Me
if (request.isSurpriseMe()) {

    // Hotels
    List<Hotel> topHotels = hotels.subList(0, Math.min(5, hotels.size()));
    Collections.shuffle(topHotels);
    hotels = topHotels.subList(0, Math.min(1, topHotels.size()));

    // Restaurants
    List<Restaurant> topRestaurants =
            restaurants.subList(0, Math.min(5, restaurants.size()));
    Collections.shuffle(topRestaurants);
    restaurants =
            topRestaurants.subList(0, Math.min(2, topRestaurants.size()));

    // Attractions
    List<Attraction> topAttractions =
            attractions.subList(0, Math.min(5, attractions.size()));
    Collections.shuffle(topAttractions);
    attractions =
            topAttractions.subList(0, Math.min(2, topAttractions.size()));

    // Events
    List<Event> topEvents =
            events.subList(0, Math.min(5, events.size()));
    Collections.shuffle(topEvents);
    events =
            topEvents.subList(0, Math.min(2, topEvents.size()));
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
            "street food",
            "fine dining"
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
            "photo",
            "instagram",
            "influencer",
            "scenic"
          );

        case "nature explorer":
            return List.of(
            "nature",
            "park",
            "lake",
            "wildlife",
            "relaxation",
            "adventure"
            );

        case "business traveller":
            return List.of(
                    "business traveller",
                    "business"
            );

        case "student":
           return List.of(
            "student",
            "students",
            "college"
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

private int calculatePersonaScore(String databaseValue, String selectedPersona) {

    if (matchesBestFor(databaseValue, selectedPersona)) {
        return 40;
    }

    return 0;
}

private int calculateBudgetScore(String itemBudget, String userBudget) {

    if (itemBudget == null || userBudget == null
            || userBudget.isBlank()) {
        return 0;
    }

    itemBudget = itemBudget.toLowerCase();
    userBudget = userBudget.toLowerCase();

    switch (userBudget) {

        case "budget":

    if (itemBudget.contains("budget"))
        return 20;

    if (itemBudget.contains("mid"))
        return 15;

    if (itemBudget.contains("premium"))
        return 10;

    if (itemBudget.contains("luxury"))
        return 5;

    break;

        case "mid-range":

    if (itemBudget.contains("mid"))
        return 20;

    if (itemBudget.contains("premium"))
        return 18;

    if (itemBudget.contains("luxury"))
        return 12;

    break;

        case "luxury":

    if (itemBudget.contains("luxury"))
        return 20;

    if (itemBudget.contains("premium"))
        return 15;

    if (itemBudget.contains("mid"))
        return 8;

    break;
    }

    return 0;
}

private int calculateTimeScore(String attractionTime, String userTime) {

    if (attractionTime == null || userTime == null
            || userTime.isBlank()) {
        return 0;
    }

    attractionTime = attractionTime.toLowerCase();
    userTime = userTime.toLowerCase();

    switch (userTime) {

        case "1 hour":

            if (attractionTime.equals("1 hour"))
                return 20;

            if (attractionTime.equals("1-2 hours"))
                return 15;

            break;

        case "1-2 hours":

            if (attractionTime.equals("1-2 hours"))
                return 20;

            if (attractionTime.equals("1 hour")
                    || attractionTime.equals("2 hours"))
                return 15;

            break;

        case "2 hours":

            if (attractionTime.equals("2 hours"))
                return 20;

            if (attractionTime.equals("1-2 hours"))
                return 18;

            if (attractionTime.equals("2-3 hours"))
                return 15;

            if (attractionTime.equals("1 hour"))
                return 10;

            break;

        case "2-3 hours":

            if (attractionTime.equals("2-3 hours"))
                return 20;

            if (attractionTime.equals("2 hours")
                    || attractionTime.equals("3-4 hours"))
                return 15;

            break;

        case "3-4 hours":

            if (attractionTime.equals("3-4 hours"))
                return 20;

            if (attractionTime.equals("2-3 hours"))
                return 15;

            break;

        case "full day":

            if (attractionTime.equals("full day"))
                return 20;

            return 10;
    }

    return 0;
}

private int calculateTransportScore(String attractionTime,
                                    String transport) {

    if (attractionTime == null || transport == null
            || transport.isBlank()) {
        return 0;
    }

    attractionTime = attractionTime.toLowerCase();
    transport = transport.toLowerCase();

    switch (transport) {

        case "walking":

            if (attractionTime.contains("1"))
                return 10;

            if (attractionTime.contains("2"))
                return 8;

            return 2;

        case "bike":

            if (attractionTime.contains("1")
                    || attractionTime.contains("2"))
                return 10;

            if (attractionTime.contains("3"))
                return 8;

            return 5;

        case "car":

            return 10;

        default:

            return 0;
    }
}

private int calculateRatingScore(Double rating) {

    if (rating == null) {
        return 0;
    }

    if (rating >= 4.8)
        return 10;

    if (rating >= 4.5)
        return 8;

    if (rating >= 4.0)
        return 5;

    return 2;
}

}