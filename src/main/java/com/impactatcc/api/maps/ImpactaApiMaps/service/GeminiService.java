package com.impactatcc.api.maps.ImpactaApiMaps.service;

import com.impactatcc.api.maps.ImpactaApiMaps.client.gemini.GeminiClient;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.PromptResponse;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.gemini.GeminiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {
    @Autowired
    private GeminiClient geminiClient;

    public PromptResponse callApi(final String prompt) {
        final GeminiResponse response = geminiClient.sendPrompt(prompt);
        return buildResponse(response);
    }

    private PromptResponse buildResponse(final GeminiResponse response) {
        if (response == null) return null;
        else if (response.getCandidates().isEmpty()) return null;
        else if (response.getCandidates().get(0).getContent() == null) return null;
        else if (response.getCandidates().get(0).getContent().getParts().isEmpty()) return null;
        else if (response.getCandidates().get(0).getContent().getParts().get(0).getText() == null) return null;

        return new PromptResponse(response.getCandidates().get(0).getContent().getParts().get(0).getText());
    }
}
