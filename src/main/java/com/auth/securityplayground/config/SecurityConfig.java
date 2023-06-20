package com.auth.securityplayground.config;


import com.auth.securityplayground.constants.SecurityConstants;
import com.auth.securityplayground.filters.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    // default config comes from configuration
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        // do not create jsession id for each request
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors( corsConfigurer -> corsConfigurer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration corsConfiguration = new CorsConfiguration();
                        //corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                        // the following statement not working use allowedOriginPattern
                        // //corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
                        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
                        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                        corsConfiguration.setAllowCredentials(Boolean.TRUE);
                        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                        // define custom header with exposeHeader to expose JWT header
                        corsConfiguration.setExposedHeaders(Arrays.asList(SecurityConstants.JWT_HEADER));
                        corsConfiguration.setMaxAge(3600L);

                        return corsConfiguration;
                    }
                 }))
                //.csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact", "/register")
                .csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/register")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                // execute csrf cookie filter after authentication filter
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                // add custom filter
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                // use before or after filter instead of at filter
                .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount").hasAuthority("VIEWACCOUNT")
                        //.requestMatchers("/myLoans").hasAnyAuthority("VIEWLOANS")
                        // we can use either Authority or Role - cannot use both
                        // NOTE: In the database roles are saved ROLE_ prefix as follows: ROLE_ADMIN, ROLE_USER
                        // however use without ROLE_
                        .requestMatchers("/myLoans").hasAnyRole("USER", "ADMIN")
                        //.requestMatchers("/myCards").hasAnyAuthority("VIEWCARDS")
                        .requestMatchers("/myCards").hasRole("ADMIN")
                        .requestMatchers("/myBalance").hasAnyAuthority("VIEWACCOUNT", "VIEWBALANCE")
                        .requestMatchers("/user").authenticated()
                        //.requestMatchers(HttpMethod.OPTIONS, "/register/**").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/register/**").permitAll()
                        .requestMatchers("/notices", "/contact", "/register").permitAll()

                );

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}


