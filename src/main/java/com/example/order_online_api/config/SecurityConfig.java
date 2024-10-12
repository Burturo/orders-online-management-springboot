package com.example.order_online_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(
                                // Autoriser l'accès à Swagger UI
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).permitAll() // Permettre l'accès sans authentification
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll() // Autoriser l'accès à l'endpoint d'inscription
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll() // Autoriser l'accès à l'endpoint de connexion
                        .anyRequest().authenticated() // Authentifier toutes les autres requêtes
                );
        return http.build();
    }
}
