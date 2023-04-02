package com.imtiyaj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }
}