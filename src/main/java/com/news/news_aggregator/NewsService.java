package com.news.news_aggregator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.news.news_aggregator.model.NewsResponse;

@Service
public class NewsService {
    private final WebClient webClient;
    private final String apiKey;

    // Constructor injection for WebClient and API key
    public NewsService(WebClient.Builder builder, 
                       @Value("${newsapi.key}") String apiKey) {
        this.webClient = builder.baseUrl("https://newsapi.org/v2").build();
        this.apiKey = apiKey;
    }

    // Fetch raw JSON string from API
    public String getTopHeadlines() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/top-headlines")
                        .queryParam("country", "us")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    // Fetch and map JSON to NewsResponse object
    public NewsResponse getTopHeadlinesAsObject() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/top-headlines")
                        .queryParam("country", "us")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(NewsResponse.class)
                .block();
    }
}
