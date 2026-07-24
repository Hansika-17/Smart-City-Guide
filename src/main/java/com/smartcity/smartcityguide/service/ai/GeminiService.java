package com.smartcity.smartcityguide.service.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public GeminiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String askGemini(String prompt) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String finalPrompt = """
You are the AI assistant for Smart City Guide.

Your purpose is to help tourists and travelers.

Provide:
- A brief overview
- Famous attractions
- Local food
- Best time to visit
- Useful travel tips

Keep your response friendly and under 200 words unless the user asks for more details.

User Question:
""" + prompt;

Map<String, Object> text = new HashMap<>();
text.put("text", finalPrompt);

        Map<String, Object> part = new HashMap<>();
        part.put("parts", List.of(text));

        Map<String, Object> body = new HashMap<>();
        body.put("contents", List.of(part));

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        String url = apiUrl + "?key=" + apiKey;


ResponseEntity<String> response =
        restTemplate.postForEntity(url, request, String.class);

try {

    ObjectMapper mapper = new ObjectMapper();

    JsonNode root = mapper.readTree(response.getBody());

    return root
            .path("candidates")
            .get(0)
            .path("content")
            .path("parts")
            .get(0)
            .path("text")
            .asText();

} catch (Exception e) {

    e.printStackTrace();

    return "Sorry! Something went wrong while contacting Gemini.";

}


    }
}