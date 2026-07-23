package com.smartcity.smartcityguide.service.impl;

import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.service.AIService;
import com.smartcity.smartcityguide.service.HotelService;
import com.smartcity.smartcityguide.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartcity.smartcityguide.entity.Restaurant;
import com.smartcity.smartcityguide.service.ai.GeminiService;
import java.util.List;

@Service
public class AIServiceImpl implements AIService {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private GeminiService geminiService;

    @Override
    public String chat(String message) {

        String lowerMessage = message.toLowerCase();

        if (lowerMessage.contains("hotel")) {
            return handleHotelQuery(lowerMessage);
    }

        if (lowerMessage.contains("restaurant")) {
            return handleRestaurantQuery(lowerMessage);
    }

        return geminiService.askGemini(message);
    }

    private String handleHotelQuery(String message) {

    List<Hotel> hotels;

    if (message.contains("in ")) {

    	String city = message.substring(message.indexOf("in") + 2).trim();

    	city = city.replaceAll("[^a-zA-Z ]", "").trim();

    	city = city.substring(0, 1).toUpperCase() + city.substring(1);

    	hotels = hotelService.getHotelsByCity(city);

    } else {

        hotels = hotelService.getAllHotels();
    }

    if (hotels.isEmpty()) {
        return "No hotels found.";
    }

    StringBuilder response = new StringBuilder("🏨 Hotels Available:\n\n");

    for (Hotel hotel : hotels) {
        response.append("• ")
                .append(hotel.getHotelName())
                .append(" (⭐ ")
                .append(hotel.getRating())
                .append(")\n");
    }

    return response.toString();
}
    private String handleRestaurantQuery(String message) {

        List<Restaurant> restaurants;

        if (message.contains("in ")) {

            String city = message.substring(message.indexOf("in") + 2).trim();

            city = city.replaceAll("[^a-zA-Z ]", "").trim();

            city = city.substring(0, 1).toUpperCase() + city.substring(1);

            restaurants = restaurantService.getRestaurantsByCity(city);

        } else {

            restaurants = restaurantService.getAllRestaurants();

        }

        if (restaurants.isEmpty()) {
            return "No restaurants found.";
        }

        StringBuilder response = new StringBuilder("🍽️ Restaurants Available:\n\n");

        for (Restaurant restaurant : restaurants) {
            response.append("• ")
                    .append(restaurant.getRestaurantName())
                    .append(" (⭐ ")
                    .append(restaurant.getRating())
                    .append(")\n");
        }

        return response.toString();
    }

}