package com.impactatcc.api.maps.ImpactaApiMaps.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.maps.MapsLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {

    @Value("${google.api.key}")
    private String apiKey;

    @Value("${google.api.geocode.url.location}")
    private String urlGeocode;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public GeocodingService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public MapsLocation getCoordinatesFromZipCode(String zipCode) {
        // URL da API do Google Maps Geocoding
        final String url = String.format(urlGeocode, zipCode, apiKey);

        // Fazer a requisição HTTP para a API
        final String response = restTemplate.getForObject(url, String.class);

        try {
            // Parsear a resposta JSON
            JsonNode jsonNode = objectMapper.readTree(response);
            JsonNode results = jsonNode.path("results");

            if (results.isArray() && results.size() > 0) {
                JsonNode location = results.get(0).path("geometry").path("location");
                double lat = location.path("lat").asDouble();
                double lng = location.path("lng").asDouble();

                return new MapsLocation(lat, lng);
            } else {
                throw new RuntimeException("No results found for the given ZIP code.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error parsing the Geocoding API response.", e);
        }
    }
}
