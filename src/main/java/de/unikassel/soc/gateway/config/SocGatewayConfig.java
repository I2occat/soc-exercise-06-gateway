package de.unikassel.soc.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocGatewayConfig {

    @Bean
    public RouteLocator configGateway(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("product", r -> r.path("/api/v1/product*", "/api/v1/product/**")
                        .uri("lb://socproduct"))
                .route("customer", r -> r.path("/api/v1/customer/**")
                        .uri("lb://soccustomer"))
                .build();
    }
}
