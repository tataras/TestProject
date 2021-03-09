package com.tatara.second.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalService {

    private final RestTemplate restTemplate;

    public ExternalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String get() {
        return restTemplate.getForEntity("http://localhost:8081/first2", String.class).getBody();
    }
}
