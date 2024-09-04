package com.impactatcc.api.maps.ImpactaApiMaps.dto.gemini;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeminiResponse {

    private List<Candidate> candidates;
    private UsageMetadata usageMetadata;
}