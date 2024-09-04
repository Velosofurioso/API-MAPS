package com.impactatcc.api.maps.ImpactaApiMaps.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.maps.MapsPlacesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleMapsService {

    @Value("${google.api.key}")
    private String apiKey;

    @Value("${google.api.maps.url.search}")
    private String searchUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public GoogleMapsService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public MapsPlacesResponse searchHospitals(double latitude, double longitude, int radius) throws JsonProcessingException {

        String requestUrl = UriComponentsBuilder.fromHttpUrl(searchUrl)
                .queryParam("location", latitude + "," + longitude)
                .queryParam("radius", radius)
                .queryParam("type", "hospital")
                .queryParam("key", apiKey)
                .toUriString();

        return restTemplate.getForObject(requestUrl, MapsPlacesResponse.class);

        /*String response = restTemplate.getForObject(requestUrl, String.class);
        JsonNode jsonNode = objectMapper.readTree(response);

        StringBuilder result = new StringBuilder();
        for (JsonNode place : jsonNode.path("results")) {
            String name = place.path("name").asText();
            String vicinity = place.path("vicinity").asText();
            result.append(String.format("Name: %s, Address: %s%n", name, vicinity));
        }

        return result.toString();*/
    }
}
