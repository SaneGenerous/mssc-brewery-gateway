package com.sfg.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile("google")
//@Configuration
public class GoogleConfig {
        /**
        * This is just an example of routing request  to Google from localhost. For demonstration only.
        * */
    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/googlesearch")
                        .filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
                        .uri("https://www.google.com")
                        .id("google"))
                .build();
    }
}
