package com.example.aui_lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ShopCategoriesApp {

    public static void main(String[] args) {
        SpringApplication.run(ShopCategoriesApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate(@Value("${shop.device.url}") String baseUrl) {
        return new RestTemplateBuilder().rootUri(baseUrl).build();
    }
}
