package com.tatara.second;

import com.tatara.second.service.ExternalService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    public ExternalService nameService() {
        return Mockito.mock(ExternalService.class);
    }
}
