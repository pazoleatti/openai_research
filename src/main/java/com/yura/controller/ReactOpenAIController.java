package com.yura.controller;

import com.yura.service.ReactOpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class ReactOpenAIController {
    private final ReactOpenAIService reactOpenAIService;

    public ReactOpenAIController(ReactOpenAIService reactOpenAIService) {
        this.reactOpenAIService = reactOpenAIService;
    }

    @PostMapping("/enrich-data")
    public Flux<String> enrichData(@RequestBody List<String> dataList) {
        Flux<String> dataStream = Flux.fromIterable(dataList);
        return reactOpenAIService.enrichData(dataStream);
    }

}
