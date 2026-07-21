package com.smartcity.smartcityguide.service.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

        Map<String, Object> text = new HashMap<>();
        text.put("text", prompt);

        Map<String, Object> part = new HashMap<>();
        part.put("parts", List.of(text));

        Map<String, Object> body = new HashMap<>();
        body.put("contents", List.of(part));

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        String url = apiUrl + "?key=" + apiKey;

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, request, String.class);

        return response.getBody();
    }
}