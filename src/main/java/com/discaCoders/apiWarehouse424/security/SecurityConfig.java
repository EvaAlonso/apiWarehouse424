package com.discaCoders.apiWarehouse424.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .build();

        UserDetails usuario = User.builder()
                .username("usuario")
                .password("{noop}usuario")
                .build();
        return new InMemoryUserDetailsManager(admin, usuario);
    }
}
