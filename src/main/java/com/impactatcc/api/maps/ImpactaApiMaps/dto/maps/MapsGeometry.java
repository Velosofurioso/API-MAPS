package com.impactatcc.api.maps.ImpactaApiMaps.dto.maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsGeometry {

    private MapsLocation location;
    private MapsViewport viewport;
}
