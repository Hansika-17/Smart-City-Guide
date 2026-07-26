package com.smartcity.smartcityguide.controller;

import com.smartcity.smartcityguide.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smartcity.smartcityguide.dto.ChatRequest;
@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AIController {

    @Autowired
    private AIService aiService;

    @PostMapping("/chat")
public ResponseEntity<String> chat(@RequestBody ChatRequest request) {

    return ResponseEntity.ok(
            aiService.chat(request.getMessage())
    );
}
}