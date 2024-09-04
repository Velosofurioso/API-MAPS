package com.impactatcc.api.maps.ImpactaApiMaps.dto.gemini;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SafetyRating {

    private String category;
    private String probability;
}

