package com.impactatcc.api.maps.ImpactaApiMaps.controller;

import com.impactatcc.api.maps.ImpactaApiMaps.dto.PromptResponse;
import com.impactatcc.api.maps.ImpactaApiMaps.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gemini")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    @GetMapping("/chat")
    public ResponseEntity<PromptResponse> getResponse(@RequestParam("prompt") final String prompt) {
        final PromptResponse response = geminiService.callApi(prompt);
        if (response == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(response);
    }
}
