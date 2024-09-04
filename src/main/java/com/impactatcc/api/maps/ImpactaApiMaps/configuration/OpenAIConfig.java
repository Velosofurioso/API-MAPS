package com.impactatcc.api.maps.ImpactaApiMaps.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@Configuration
public class OpenAIConfig {

    @Value("${openai.api.key}")
    String openaiApiKey;

    @Bean
    public RestTemplate template() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openaiApiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
