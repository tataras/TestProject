package com.tatara.second;

import com.tatara.second.service.ExternalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public class SecondEndpointTest extends BaseIntegrationTest {

    @Autowired
    private ExternalService externalService;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void secondTest() {
        Mockito.when(externalService.get()).thenReturn("{\"time\":\"11:15:49 2021-03-09\",\"number\":12,\"message\":\"message\"}");

        webClient.get()
                .uri("/second2")
                .exchange()
                .expectBody()
                .json("{\"time\":\"11:15:49 2021-03-09\",\"number\":12.0,\"message\":\"message\"}");
    }
}
