package com.tatara.second;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.tatara.second.dto.TestDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EndpointTest extends BaseIntegrationTest {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    private static final WireMockServer wireMockServer = new WireMockServer(8081);

    @LocalServerPort
    private int port;

    @BeforeAll
    public static void prepare() {
        wireMockServer.start();
        configureFor("localhost", 8081);
        stubFor(get(urlEqualTo("/first")).willReturn(aResponse().withBody("test message")));
    }

    @AfterAll
    public static void clean() {
        wireMockServer.stop();
    }

    @Test
    public void firstTest() {
        ResponseEntity<TestDTO> response = testRestTemplate.
                getForEntity("http://localhost:" + port + "/second", TestDTO.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getText(), equalTo("test message"));
    }
}
