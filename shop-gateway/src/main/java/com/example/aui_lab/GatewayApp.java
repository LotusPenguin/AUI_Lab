package com.example.aui_lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${shop.device.url}") String deviceUrl,
            @Value("${shop.category.url}") String categoryUrl,
            @Value("${shop.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("categories", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/categories/{uuid}",
                                "/api/categories")
                        .uri(categoryUrl)
                )
                .route("devices", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/devices",
                                "/api/devices/**",
                                "/api/categories/{uuid}/devices",
                                "/api/categories/{uuid}/devices/**")
                        .uri(deviceUrl)
                )
                .build();
    }
}