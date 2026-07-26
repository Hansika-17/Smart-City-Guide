package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.entity.Attraction;
import com.smartcity.smartcityguide.entity.Event;

import com.smartcity.smartcityguide.service.AttractionService;
import com.smartcity.smartcityguide.service.EventService;
import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.service.AIService;
import com.smartcity.smartcityguide.service.HotelService;
import com.smartcity.smartcityguide.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartcity.smartcityguide.entity.Restaurant;
import com.smartcity.smartcityguide.service.ai.GeminiService;
import java.util.List;
import com.smartcity.smartcityguide.service.ai.parser.AIQueryParser;
@Service
public class AIServiceImpl implements AIService {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
private AttractionService attractionService;

@Autowired
private EventService eventService;

    @Autowired
    private GeminiService geminiService;

    @Override
public String chat(String message) {

    String lowerMessage = message.toLowerCase();

    if (lowerMessage.contains("hotel")) {
        return handleHotelQuery(lowerMessage);
    }

    else if (lowerMessage.contains("restaurant")) {
        return handleRestaurantQuery(lowerMessage);
    }

    else if (
            lowerMessage.contains("attraction") ||
            lowerMessage.contains("attractions") ||
            lowerMessage.contains("tourist") ||
            lowerMessage.contains("visit") ||
            lowerMessage.contains("place") ||
            lowerMessage.contains("places")
    ) {

        return handleAttractionQuery(lowerMessage);

    }

    else if (
            lowerMessage.contains("event") ||
            lowerMessage.contains("events") ||
            lowerMessage.contains("festival") ||
            lowerMessage.contains("concert")
    ) {

        return handleEventQuery(lowerMessage);

    }

    return geminiService.askGemini(message);
}

    private String handleHotelQuery(String message) {

    List<Hotel> hotels;

    String city = AIQueryParser.extractCity(message);
    String budget = AIQueryParser.extractBudget(message);
    String bestFor = AIQueryParser.extractBestFor(message);

    if (city != null && budget != null && bestFor != null) {

        hotels = hotelService.getHotelsByCityAndPriceRangeAndBestFor(
                city,
                budget,
                bestFor
        );

    } else if (city != null && budget != null) {

        hotels = hotelService.getHotelsByCityAndPriceRange(
                city,
                budget
        );

    } else if (city != null && bestFor != null) {

        hotels = hotelService.getHotelsByCityAndBestFor(
                city,
                bestFor
        );

    } else if (budget != null) {

        hotels = hotelService.getHotelsByPriceRange(
                budget
        );

    } else if (bestFor != null) {

        hotels = hotelService.getHotelsByBestFor(
                bestFor
        );

    } else if (city != null) {

        hotels = hotelService.getHotelsByCity(
                city
        );

    } else {

        hotels = hotelService.getAllHotels();

    }

    if (hotels.isEmpty()) {
        return "No hotels found.";
    }

    StringBuilder response = new StringBuilder("🏨 Hotels\n\n");

    for (Hotel hotel : hotels) {

        response.append("🏨 ")
                .append(hotel.getHotelName())
                .append("\n")
                .append("⭐ ")
                .append(hotel.getRating())
                .append("\n")
                .append("💰 ")
                .append(hotel.getPriceRange())
                .append("\n")
                .append("📍 ")
                .append(hotel.getCity())
                .append("\n\n");
    }

    return response.toString();
}
    private String handleRestaurantQuery(String message) {

    List<Restaurant> restaurants;

    String city = AIQueryParser.extractCity(message);
    String budget = AIQueryParser.extractBudget(message);
    //System.out.println("Budget = " + budget);

    String bestFor = AIQueryParser.extractBestFor(message);

    if (city != null && budget != null && bestFor != null) {

        restaurants = restaurantService.getRestaurantsByCityAndPriceRangeAndBestFor(
                city,
                budget,
                bestFor
        );

    } else if (city != null && budget != null) {

        restaurants = restaurantService.getRestaurantsByCityAndPriceRange(
                city,
                budget
        );

    } else if (city != null && bestFor != null) {

        restaurants = restaurantService.getRestaurantsByCityAndBestFor(
                city,
                bestFor
        );

    } else if (budget != null) {

        restaurants = restaurantService.getRestaurantsByPriceRange(
                budget
        );

    } else if (bestFor != null) {

        restaurants = restaurantService.getRestaurantsByBestFor(
                bestFor
        );

    } else if (city != null) {

        restaurants = restaurantService.getRestaurantsByCity(
                city
        );

    } else {

        restaurants = restaurantService.getAllRestaurants();

    }

    if (restaurants.isEmpty()) {
        return "No restaurants found.";
    }

    StringBuilder response = new StringBuilder("🍽️ Restaurants\n\n");

    for (Restaurant restaurant : restaurants) {

        response.append("🍽️ ")
                .append(restaurant.getRestaurantName())
                .append("\n")
                .append("⭐ ")
                .append(restaurant.getRating())
                .append("\n")
                .append("💰 ")
                .append(restaurant.getPriceRange())
                .append("\n")
                .append("📍 ")
                .append(restaurant.getCity())
                .append("\n\n");

    }

    return response.toString();
}
private String handleAttractionQuery(String message) {

    List<Attraction> attractions;

    String city = AIQueryParser.extractCity(message);

    if (city != null) {

        attractions = attractionService.getAttractionsByCity(city);

    } else {

        attractions = attractionService.getAllAttractions();

    }

    if (attractions.isEmpty()) {
        return "No attractions found.";
    }

    StringBuilder response = new StringBuilder("🏛️ Attractions:\n\n");

    for (Attraction attraction : attractions) {

        response.append("• ")
                .append(attraction.getAttractionName())
                .append(" (⭐ ")
                .append(attraction.getRating())
                .append(")\n");

    }

    return response.toString();
}
private String handleEventQuery(String message) {

    List<Event> events;

String city = AIQueryParser.extractCity(message);
String category = AIQueryParser.extractEventCategory(message);

if (city != null && category != null) {

    events = eventService.getEventsByCityAndCategory(city, category);

} else if (city != null) {

    events = eventService.getEventsByCity(city);

} else if (category != null) {

    events = eventService.getEventsByCategory(category);

} else {

    events = eventService.getAllEvents();

}

    if (events.isEmpty()) {
        return "No events found.";
    }

    StringBuilder response = new StringBuilder("🎉 Events:\n\n");

    for (Event event : events) {

        response.append("• ")
                .append(event.getEventName())
                .append("\n")
                .append("📍 ")
                .append(event.getVenue())
                .append("\n")
                .append("🎭 ")
                .append(event.getCategory())
                .append("\n\n");

    }

    return response.toString();
}

}