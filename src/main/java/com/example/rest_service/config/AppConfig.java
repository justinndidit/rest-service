package com.example.rest_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest_service.mockDatabase.Employees;

@Configuration
public class AppConfig {
    @Bean
    public Employees employees() {
        return new Employees();
    }
}
