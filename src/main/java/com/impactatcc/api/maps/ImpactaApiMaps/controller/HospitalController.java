package com.impactatcc.api.maps.ImpactaApiMaps.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.maps.MapsLocation;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.maps.MapsPlacesResponse;
import com.impactatcc.api.maps.ImpactaApiMaps.service.GeocodingService;
import com.impactatcc.api.maps.ImpactaApiMaps.service.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private GoogleMapsService googleMapsService;

    @Autowired
    private GeocodingService geocodingService;

    @GetMapping("/hospitals")
    public ResponseEntity<MapsPlacesResponse> getHospitals(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int radius) throws JsonProcessingException {
        final MapsPlacesResponse response = googleMapsService.searchHospitals(latitude, longitude, radius);
        if (response == null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/hospitals-cep")
    public ResponseEntity<MapsPlacesResponse> getHospitalsByCep(@RequestParam String zipCode, @RequestParam int radius) throws JsonProcessingException {
        final MapsLocation response = geocodingService.getCoordinatesFromZipCode(zipCode);
        if (response == null) return ResponseEntity.noContent().build();

        return getHospitals(response.getLat(), response.getLng(), radius);
    }
}
