package com.hexagonal.shared.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security configuration for the application.
 *
 * <p>Phase 5 / T006 — establishes the security baseline:</p>
 * <ul>
 *   <li>Stateless (no HTTP session).</li>
 *   <li>CSRF disabled (REST API with Bearer tokens).</li>
 *   <li>{@link SessionJwtAuthenticationFilter} registered to populate SecurityContext
 *       from the application's own JWT on every request.</li>
 *   <li>Public endpoint: {@code POST /api/identity/auth/google} (C1/C2 — no auth needed to log in).</li>
 *   <li>All other requests: {@code permitAll()} for now — T007/T008 will apply
 *       method-level security once all controllers are migrated to SecurityContext-based userId.</li>
 * </ul>
 *
 * <p>Use {@link org.springframework.security.core.context.SecurityContextHolder} in controllers
 * and use cases to extract the authenticated {@code userId (UUID)} after migration.</p>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
            SessionJwtAuthenticationFilter sessionJwtAuthenticationFilter) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/api/identity/auth/google").permitAll()
                .requestMatchers("/api/identity/auth/logout").authenticated()   // C4: logout requires token
                .anyRequest().permitAll()  // existing BCs can still be called; T008 will enforce auth
            )
            .addFilterBefore(sessionJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
