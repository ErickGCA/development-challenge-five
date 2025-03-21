package com.example.medcloud.config;

import com.example.medcloud.exception.InvalidAPIKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
    
    private final String validApiKey;

    public SecurityConfig(@Value("${app.api.key}") String validApiKey) {
        this.validApiKey = validApiKey;
        System.out.println("API Key esperada: " + this.validApiKey); // 🔍 Verifica se a API Key está sendo carregada
    }

    public void validateApiKey(String apiKey) {
        System.out.println("API Key recebida: " + apiKey); // 🔍 Verifica a API Key recebida
        if (!validApiKey.equals(apiKey)) {
            throw new InvalidAPIKeyException("Invalid API Key. Use: " + validApiKey);
        }
    }
}
