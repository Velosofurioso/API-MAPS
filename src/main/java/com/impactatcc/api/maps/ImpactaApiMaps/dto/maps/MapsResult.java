package com.impactatcc.api.maps.ImpactaApiMaps.dto.maps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsResult {

    private String business_status;
    private MapsGeometry geometry;
    private String icon;
    private String icon_background_color;
    private String icon_mask_base_uri;
    private String name;
    private MapsOpeningHours opening_hours;
    private List<MapsPhoto> photos;
    private String place_id;
    private MapsPlusCode plus_code;
    private double rating;
    private String reference;
    private String scope;
    private List<String> types;
    private int user_ratings_total;
    private String vicinity;
}
