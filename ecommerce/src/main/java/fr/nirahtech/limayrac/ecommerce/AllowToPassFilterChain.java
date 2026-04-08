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
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/logout").permitAll()
                .requestMatchers("/api/products/**").hasRole("OAUTH2_USER")
                .anyRequest().permitAll()
            )
            .userDetailsService(jdbcUserDetailsManager)
            .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/api/users"));
        return http.build();
    }
 

}
