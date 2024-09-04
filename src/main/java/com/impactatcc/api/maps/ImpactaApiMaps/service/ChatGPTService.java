package com.impactatcc.api.maps.ImpactaApiMaps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChatGPTService {

    @Autowired
    private WebClient webClient;

    public Mono<String> getChatGPTResponse(String prompt) {
        return webClient.post()
                .uri("/chat/completions")
                .header("Content-Type", "application/json")
                .bodyValue("{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}], \"max_tokens\": 150}")
                .retrieve()
                .bodyToMono(String.class);
                /*.retryWhen(Retry.backoff(5, Duration.ofSeconds(1)) // Retry up to 5 times with exponential backoff
                        .filter(throwable -> throwable instanceof WebClientResponseException.TooManyRequests))
                .onErrorResume(throwable -> Mono.just("Rate limit exceeded. Please try again later."));*/
    }
}

