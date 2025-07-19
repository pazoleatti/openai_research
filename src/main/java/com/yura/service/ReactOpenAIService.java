package com.yura.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;
@Service
public class ReactOpenAIService {
    private final WebClient webClient;
    private final String apiUrl;

    private final String apiKey;
    private final String model;

    public ReactOpenAIService(WebClient.Builder webClientBuilder,
                              @Value("${openai.api.url}")String apiUrl,
                              @Value("${openai.api.key}")String apiKey,
                              @Value("${open.api.model.gpt3}") String model) {
        this.webClient = webClientBuilder.baseUrl(apiUrl + "/chat/completions")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.model = model;
    }

    public Flux<String> enrichData(Flux<String> dataStream) {
        return dataStream.flatMap(this::enrichSingleItem);
    }

    public Mono<String> enrichSingleItem(String data) {
        String prompt =  "Provide a summary and sentiment analysis for the following text: \"" + data + "\"";
        Map<String, Object> message = Map.of("role", "developer", "content", prompt);
        Mono<String> toReturn = this.webClient
                .post()
                .bodyValue(Map.of("model", model, "messages", Collections.singletonList(message), "temperature", 0.5, "max_tokens", 100))
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> "Original: " + data + " | Enrichment: " + response);
        return toReturn;
    }
}
