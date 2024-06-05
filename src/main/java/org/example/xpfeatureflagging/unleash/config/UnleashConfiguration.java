package org.example.xpfeatureflagging.unleash.config;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.util.UnleashConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnleashConfiguration {

    @Bean
    public Unleash unleash() {
        return new DefaultUnleash(UnleashConfig.builder()
                .appName("tickets-service")
                .instanceId("my-instance-1")
                .unleashAPI("http://localhost:4242/api/")
                .apiKey("default:development.unleash-insecure-api-token")
                .projectName("default")
                .build()
        );
    }

}