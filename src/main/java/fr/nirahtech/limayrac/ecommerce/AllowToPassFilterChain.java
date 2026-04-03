package fr.nirahtech.limayrac.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AllowToPassFilterChain  {

    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;

    // @Autowired
    // private JdbcUserDetailsManager jdbcUserDetailsManager;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .and()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/products/**")
                .authenticated()

                .anyRequest()
                .permitAll()
            )
            .userDetailsService(inMemoryUserDetailsManager);
            // .userDetailsService(jdbcUserDetailsManager);
        return http.build();
    }
 

}
