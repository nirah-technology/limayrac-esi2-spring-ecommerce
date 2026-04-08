package fr.limayrac.esi2.dumb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient

public class DumbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DumbApplication.class, args);
	}

}
