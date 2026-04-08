package fr.nirahtech.limayrac.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AllowToPassFilterChain  {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Désactivé pour faciliter les tests API (Postman)
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/products/**", "/api/users/**")
                .authenticated()
                .anyRequest()
                .permitAll()
            )
            .userDetailsService(jdbcUserDetailsManager);
        return http.build();
    }
 

}
