package com.impactatcc.api.maps.ImpactaApiMaps.controller;

import com.impactatcc.api.maps.ImpactaApiMaps.dto.gpt.ChatGPTRequest;
import com.impactatcc.api.maps.ImpactaApiMaps.dto.gpt.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gpt")
public class ChatGPTController {

    /*private final ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @GetMapping("/chatgpt")
    public Mono<String> getChatGPTResponse(@RequestParam String prompt) {
        return chatGPTService.getChatGPTResponse(prompt);
    }*/

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam("prompt") String prompt) {
        ChatGPTRequest request = new ChatGPTRequest(model, prompt);
        final ChatGptResponse chatGptResponse = template.postForObject(apiURL, request, ChatGptResponse.class);
        if (chatGptResponse == null)
            return ResponseEntity.noContent().build();

        else if (chatGptResponse.getChoices().isEmpty())
            return ResponseEntity.noContent().build();

        else if (chatGptResponse.getChoices().get(0).getMessage() == null)
            return ResponseEntity.noContent().build();

        else if (chatGptResponse.getChoices().get(0).getMessage().getContent() == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(chatGptResponse.getChoices().get(0).getMessage().getContent());
    }
}
