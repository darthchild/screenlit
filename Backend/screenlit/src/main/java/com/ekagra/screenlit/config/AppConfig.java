package com.ekagra.screenlit.config;

import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // for Spring Actuator
    @Bean
    public HttpExchangeRepository httpTraceRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
