package com.github.joba.pledger.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .requestMatchers("/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .oauth2Login(Customizer.withDefaults());
//                .oauth2Login(oauth2 -> oauth2.successHandler(new SavedRequestAwareAuthenticationSuccessHandler()));
        return http.build();
    }
}
