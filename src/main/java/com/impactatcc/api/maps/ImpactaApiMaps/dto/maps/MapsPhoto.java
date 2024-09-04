package com.impactatcc.api.maps.ImpactaApiMaps.dto.maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsPhoto {
    private int height;
    private List<String> html_attributions;
    private String photo_reference;
    private int width;
}
