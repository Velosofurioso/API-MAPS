package com.impactatcc.api.maps.ImpactaApiMaps.dto.maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsViewport {

    private MapsLocation northeast;
    private MapsLocation southwest;
}
