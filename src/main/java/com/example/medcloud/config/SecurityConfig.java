package com.example.medcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF para testes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/patients/**").permitAll() // Permite acesso sem autenticação
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}