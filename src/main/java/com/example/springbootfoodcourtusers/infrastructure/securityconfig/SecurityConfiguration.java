package com.example.springbootfoodcourtusers.infrastructure.securityconfig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.Role.ADMIN;
import static com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.Role.OWNER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf ->csrf.disable())
                .authorizeHttpRequests(authorizeRequest -> authorizeRequest
                        .requestMatchers("/auth/**", "/v2/api-docs",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "/swagger-ui.html").permitAll()
                        .requestMatchers("/admin/**").hasAnyRole(ADMIN.name())
                        .requestMatchers("/owner/**").hasAnyRole(OWNER.name())
                        .anyRequest().authenticated()
                )
//                .exceptionHandling(excepcionHandling -> excepcionHandling.accessDeniedHandler(customAccessDeniedHandler))
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
