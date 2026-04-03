package fr.nirahtech.limayrac.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
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
			nicolas.setAuthorities(List.of("ROLE_USER", "ROLE_ADMIN"));
	
			this.usersRepository.save(
				nicolas
			);
		}
	}

}
