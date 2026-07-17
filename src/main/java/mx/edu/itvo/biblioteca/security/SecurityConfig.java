package mx.edu.itvo.biblioteca.config;

import mx.edu.itvo.biblioteca.security.JwtAuthenticationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuración principal de Spring Security.
 *
 * Define la configuración base de seguridad
 * para el Sistema Integral de Biblioteca.
 *
 * @author Conce
 * @version 2.0
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Filtro JWT.
     */
    private final JwtAuthenticationFilter
            jwtAuthenticationFilter;

    /**
     * Constructor.
     *
     * @param jwtAuthenticationFilter
     *        Filtro JWT.
     */
    public SecurityConfig(
            JwtAuthenticationFilter
                    jwtAuthenticationFilter) {

        this.jwtAuthenticationFilter =
                jwtAuthenticationFilter;

    }

    /**
     * Configura Spring Security.
     *
     * @param http Configuración HTTP.
     * @return SecurityFilterChain.
     * @throws Exception Error.
     */
    @Bean
    public SecurityFilterChain
            securityFilterChain(
                    HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf ->
                        csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth ->
                        auth

                                .requestMatchers(
                                        "/api/auth/**")
                                .permitAll()

                                .requestMatchers(
                                        "/swagger",
                                        "/swagger/**",
                                        "/swagger-ui/**",
                                        "/swagger-ui.html",
                                        "/api-docs",
                                        "/api-docs/**",
                                        "/v3/api-docs/**")
                                .permitAll()

                                .anyRequest()
                                .authenticated())

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

    /**
     * PasswordEncoder.
     *
     * @return BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder
            passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    /**
     * AuthenticationManager.
     *
     * @param configuration Configuración.
     * @return AuthenticationManager.
     * @throws Exception Error.
     */
    @Bean
    public AuthenticationManager
            authenticationManager(
                    AuthenticationConfiguration
                            configuration)
            throws Exception {

        return configuration
                .getAuthenticationManager();

    }

}