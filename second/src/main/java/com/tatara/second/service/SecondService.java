package com.tatara.second.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tatara.second.dto.SecondDTO;
import com.tatara.second.dto.TestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SecondService {

    private final RestTemplate restTemplate;
    private final ExternalService externalService;

    public SecondService(RestTemplate restTemplate, ExternalService externalService) {
        this.restTemplate = restTemplate;
        this.externalService = externalService;
    }

    public TestDTO get() {
        String text = restTemplate.getForEntity("http://localhost:8081/first", String.class).getBody();
        return new TestDTO(text);
    }

    public SecondDTO get2() {
        String json = externalService.get();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(json, SecondDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
