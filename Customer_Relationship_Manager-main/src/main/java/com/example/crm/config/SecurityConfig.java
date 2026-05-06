package com.example.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security configuration class.
 *
 * Responsibilities:
 * - Configures authentication (in-memory user)
 * - Secures UI endpoints
 * - Allows public access to REST APIs (/api/**)
 * - Disables CSRF for API testing (Postman)
 */

@Configuration
public class SecurityConfig {

    /**
     * Configures HTTP security rules:
     * - Public access: login page, static resources, REST APIs
     * - All other endpoints require authentication
     **/

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers(
                            "/login",
                            "/css/**",
                            "/js/**",
                            // APIs
                            "/api/**"
                    ).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();

            return http.build();
        }
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}