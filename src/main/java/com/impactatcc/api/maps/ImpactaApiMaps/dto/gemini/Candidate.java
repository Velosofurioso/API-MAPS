package com.impactatcc.api.maps.ImpactaApiMaps.dto.gemini;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    private Content content;
    private String finishReason;
    private int index;
    private List<SafetyRating> safetyRatings;
}

