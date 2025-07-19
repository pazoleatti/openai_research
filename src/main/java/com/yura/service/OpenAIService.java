package com.yura.service;

import com.yura.dto.LLMResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OpenAIService {
    private final RestTemplate restTemplate;

    private final String apiUrl;

    private final String apiKey;
    private final String model;

    public OpenAIService(RestTemplate restTemplate,
                         @Value("${openai.api.url}")String apiUrl,
                         @Value("${openai.api.key}")String apiKey,
                         @Value("${open.api.model.gpt3}") String model) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.model = model;
    }

    public LLMResponse generateText(String prompt) {
        String endpoint = "/responses";
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> data = new HashMap<>();
        data.put("model",model);
        data.put("input", prompt);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(data, headers);

        ResponseEntity<LLMResponse> response = restTemplate.exchange(apiUrl + endpoint, HttpMethod.POST, entity, LLMResponse.class);
        return response.getBody();
    }
}
