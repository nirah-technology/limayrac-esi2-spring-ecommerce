package fr.nirahtech.limayrac.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final List<UserDetails> users = new ArrayList<>();

        users.add(User
                    .builder()
                    .username("user1")
                    .password(this.passwordEncoder().encode("123456")) // RECOMMANDED : Use encoder en encrypt password in memory
                    .build());
        

        users.add(User
                    .builder()
                    .username("user2")
                    .password(this.passwordEncoder().encode("456789")) // UNRECOMMANDED: Raw password without any encoder
                    .build());

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
