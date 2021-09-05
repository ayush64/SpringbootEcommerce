package com.ayush.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class Democlass {

    @Autowired
    private RestTemplate restTemplate;

//    public Democlass(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
}
