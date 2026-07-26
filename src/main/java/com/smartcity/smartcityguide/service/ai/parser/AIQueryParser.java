package com.smartcity.smartcityguide.service.ai.parser;

import java.util.Arrays;
import java.util.List;

public class AIQueryParser {

    public static String extractCity(String message) {

        if (!message.toLowerCase().contains(" in ")) {
            return null;
        }

        String city = message.substring(
                message.toLowerCase().indexOf(" in ") + 4
        ).trim();

        city = city.replaceAll("[^a-zA-Z ]", "").trim();

        if (city.isEmpty()) {
            return null;
        }

        return city.substring(0, 1).toUpperCase() + city.substring(1);
    }

    public static String extractBudget(String message) {

    message = message.toLowerCase();

    if (message.contains("budget")
            || message.contains("cheap")
            || message.contains("affordable")
            || message.contains("low cost")) {

        return "Budget";
    }

    if (message.contains("mid-range")
            || message.contains("mid range")
            || message.contains("moderate")) {

        return "Mid-range";
    }

    if (message.contains("luxury")
            || message.contains("premium")
            || message.contains("expensive")) {

        return "Premium";
    }

    return null;
}

    public static String extractBestFor(String message) {

        message = message.toLowerCase();

        List<String> keywords = Arrays.asList(
                "family",
                "romantic",
                "business",
                "friends",
                "beach",
                "beaches",
                "kids",
                "children"
        );

        for (String keyword : keywords) {

            if (message.contains(keyword)) {

                if (keyword.equals("beaches"))
                    return "beach";

                if (keyword.equals("children"))
                    return "kids";

                return keyword;
            }
        }

        return null;
    }
    public static String extractEventCategory(String message) {

    message = message.toLowerCase();

    if (message.contains("concert") || message.contains("music")) {
        return "Concert";
    }

    if (message.contains("food festival") || message.contains("festival")) {
        return "Food Festival";
    }

    if (message.contains("exhibition")) {
        return "Exhibition";
    }

    if (message.contains("sports") || message.contains("marathon")) {
        return "Sports";
    }

    if (message.contains("cultural")) {
        return "Cultural";
    }

    if (message.contains("entertainment")) {
        return "Entertainment";
    }

    return null;
} 
}
