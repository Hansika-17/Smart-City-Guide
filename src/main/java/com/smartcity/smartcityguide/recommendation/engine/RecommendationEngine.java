package com.smartcity.smartcityguide.recommendation.engine;

import com.smartcity.smartcityguide.entity.Hotel;
import com.smartcity.smartcityguide.entity.Restaurant;
import com.smartcity.smartcityguide.recommendation.dto.GroupRecommendationRequest;
import com.smartcity.smartcityguide.recommendation.dto.RecommendationRequest;
import com.smartcity.smartcityguide.recommendation.model.GroupMember;
import com.smartcity.smartcityguide.recommendation.model.Itinerary;
import com.smartcity.smartcityguide.recommendation.model.RecommendationResult;
import com.smartcity.smartcityguide.service.HotelService;
import com.smartcity.smartcityguide.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationEngine {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestaurantService restaurantService;

    // Later
    // @Autowired
    // private AttractionService attractionService;

    // @Autowired
    // private EventService eventService;

    // -------------------------------
    // Solo Recommendation
    // -------------------------------
    public RecommendationResult generateSoloItinerary(RecommendationRequest request) {

        RecommendationResult result = new RecommendationResult();

        // Find Best Hotel
        List<Hotel> hotels = hotelService.getHotelsByCity(request.getCity());

        if (hotels.isEmpty()) {
            result.setExplanation("No hotels found for the selected city.");
            return result;
        }

        Hotel bestHotel = hotels.get(0);

        for (Hotel hotel : hotels) {
            if (hotel.getRating() > bestHotel.getRating()) {
                bestHotel = hotel;
            }
        }

        // Find Best Restaurant
        List<Restaurant> restaurants =
                restaurantService.getRestaurantsByCity(request.getCity());

        Restaurant bestRestaurant = null;

        if (!restaurants.isEmpty()) {

            bestRestaurant = restaurants.get(0);

            for (Restaurant restaurant : restaurants) {

                if (restaurant.getRating() > bestRestaurant.getRating()) {
                    bestRestaurant = restaurant;
                }

            }

        }

        // Build Itinerary
        Itinerary itinerary = new Itinerary();

        itinerary.setHotel(bestHotel.getHotelName());

        if (bestRestaurant != null) {
            itinerary.setRestaurant(bestRestaurant.getRestaurantName());
        }

        itinerary.setExplanation(
                "Highest rated hotel and restaurant selected."
        );

        result.setItinerary(itinerary);
        result.setExplanation("Solo itinerary generated successfully.");

        return result;
    }

    // -------------------------------
    // Group Recommendation
    // -------------------------------
    public RecommendationResult generateGroupItinerary(GroupRecommendationRequest request) {

        RecommendationResult result = new RecommendationResult();

        int compatibility = calculateCompatibility(request);

        result.setCompatibilityScore(compatibility);
        result.setExplanation(
                "Group itinerary generation will be implemented after Attractions and Events are added."
        );

        return result;
    }

    // -------------------------------
    // Compatibility Score
    // -------------------------------
    public int calculateCompatibility(GroupRecommendationRequest request) {

        if (request.getMembers() == null || request.getMembers().size() < 2) {
            return 100;
        }

        int totalScore = 0;
        int comparisons = 0;

        for (int i = 0; i < request.getMembers().size(); i++) {

            for (int j = i + 1; j < request.getMembers().size(); j++) {

                totalScore += calculateScore(
                        request.getMembers().get(i),
                        request.getMembers().get(j));

                comparisons++;
            }
        }

        return totalScore / comparisons;
    }

    // -------------------------------
    // Surprise Me
    // -------------------------------
    public RecommendationResult surpriseMe(RecommendationRequest request) {

        // For now use the same recommendation.
        // Later we'll randomize it.

        return generateSoloItinerary(request);
    }

    // -------------------------------
    // Helper Method
    // -------------------------------
    private int calculateScore(GroupMember member1, GroupMember member2) {

        int score = 0;

        if (member1.getPreferences().getBudget()
                == member2.getPreferences().getBudget()) {
            score += 30;
        }

        if (member1.getPreferences().getPersona()
                == member2.getPreferences().getPersona()) {
            score += 30;
        }

        if (member1.getPreferences().getTimeAvailable()
                == member2.getPreferences().getTimeAvailable()) {
            score += 20;
        }

        if (member1.getPreferences().getTransportMode()
                == member2.getPreferences().getTransportMode()) {
            score += 20;
        }

        return score;
    }

}