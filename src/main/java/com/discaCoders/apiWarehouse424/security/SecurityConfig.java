package com.discaCoders.apiWarehouse424.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMINISTRADOR")
                .build();

        UserDetails usuario = User.builder()
                .username("usuario")
                .password("{noop}usuario")
                .roles("USUARIO")
                .build();
        return new InMemoryUserDetailsManager(admin, usuario);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/products").hasAnyRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.GET, "/api/products/**").hasRole("ADMINISTRADOR, USUARIO")
                        .requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.PUT, "/api/products").hasRole("ADMINISTRADOR")
                        .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMINISTRADOR")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

// disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
