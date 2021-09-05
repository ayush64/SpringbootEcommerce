package com.ayush.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DemoConfig {

   @Bean
    public RestTemplate restTemplate1 () {
        return new RestTemplate();
    }

   @Bean
    public Democlass democlass() {
        return new Democlass();
    }
}
