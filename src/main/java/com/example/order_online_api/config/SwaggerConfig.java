package com.example.order_online_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SwaggerConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request.requestMatchers("/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html").permitAll()
                .anyRequest().authenticated());
        return http.build();
    }

}