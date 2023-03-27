package com.example.hellorest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomWebSecurityConfigurerAdapter {

    public static final String[] SWAGGER_MATCHES = {"/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests((auth) ->
                auth
                        .requestMatchers(SWAGGER_MATCHES).permitAll()
                        .requestMatchers("/greeting/free").permitAll()
                        .anyRequest().authenticated().and()

        ).httpBasic();
        return httpSecurity.build();
    }
}
