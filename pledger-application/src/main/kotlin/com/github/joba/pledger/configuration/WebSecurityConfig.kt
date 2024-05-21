package com.github.joba.pledger.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.OAuth2LoginDsl
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

//@Configuration
//@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            oauth2Login {  }
            csrf { disable() }
            authorizeHttpRequests {
                authorize("/*", "/error", permitAll)
                authorize(anyRequest, authenticated)
            }
        }
//        http.invoke {
//            authorizeRequests {
//                authorize("/greetings/**", hasAuthority("ROLE_ADMIN"))
//                authorize("/**", permitAll)
//            }
//            httpBasic {}
//        }
        return http.build()
    }

}