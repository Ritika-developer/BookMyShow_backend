package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/movies/**").permitAll()
                .requestMatchers("/api/theatres/**").permitAll()
                .requestMatchers("/api/shows/**").permitAll()
                .requestMatchers("/api/seats/**").permitAll()
                .requestMatchers("/api/bookings/**").permitAll()
                .requestMatchers("/api/payments/**").permitAll()
                .requestMatchers("/api/cities/**").permitAll()
                .requestMatchers("/api/dashboard/**").permitAll()
                .requestMatchers("/api/users/**").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}