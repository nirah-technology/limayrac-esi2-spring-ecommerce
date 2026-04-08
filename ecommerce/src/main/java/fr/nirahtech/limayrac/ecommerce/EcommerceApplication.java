package fr.nirahtech.limayrac.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		final String username = "nicolas";

		if (!this.usersRepository.existsById(username)) {
			User nicolas = new User();
			nicolas.setUsername(username);
			nicolas.setPassword(this.passwordEncoder.encode("nicolas"));
			nicolas.setEnabled(true);
			nicolas.setAuthorities(List.of("ROLE_USER"/* , "ROLE_ADMIN"*/));
	
			this.usersRepository.save(
				nicolas
			);

			User jean = new User();
			jean.setUsername("jean");
			jean.setPassword(this.passwordEncoder.encode("jean"));
			jean.setEnabled(true);
			jean.setAuthorities(List.of("ROLE_ADMIN"/* , "ROLE_ADMIN"*/));
	
			this.usersRepository.save(
				jean
			);

			User sorenzo = new User();
			sorenzo.setUsername("sorenzo");
			sorenzo.setPassword(this.passwordEncoder.encode("sorenzo"));
			sorenzo.setEnabled(true);
			sorenzo.setAuthorities(List.of("ROLE_ADMIN", "ROLE_USER"));
	
			this.usersRepository.save(
				sorenzo
			);
		}
	}

}
