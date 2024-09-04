package com.impactatcc.api.maps.ImpactaApiMaps.dto.maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsPlacesResponse {

    private List<Object> html_attributions;
    private List<MapsResult> results;
    private String status;
}
