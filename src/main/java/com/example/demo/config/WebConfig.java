package com.example.demo.config;

import com.example.demo.services.DateTimeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public DateTimeFactory dateTimeFactory() {
        return new DateTimeFactory();
    }
}
