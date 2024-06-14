package com.example.lightweightprojects.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private static final String[] WHITE_URL_LIST = {"", ""};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(req -> 
            req.requestMatchers(WHITE_URL_LIST));

        return http.build();
    }
}










































































// youtube - https://www.youtube.com/watch?v=KxqlJblhzfI (1:28:00 - 1:35:05)
// git - https://github.com/ali-bouali/spring-boot-3-jwt-security/tree/main
