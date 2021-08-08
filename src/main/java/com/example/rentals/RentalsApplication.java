package com.example.rentals;

import com.example.rentals.users.Users;
import com.example.rentals.users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages= {"com.example.rentals.users"})
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= UsersRepository.class)

public class RentalsApplication {

	private static final Logger log= LoggerFactory.getLogger ( RentalsApplication.class );





	public static void main(String[] args) {
		SpringApplication.run(RentalsApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(UsersRepository repository) {
		return (args) -> {
			repository.save(new Users ("Jack", "Baue@r","pass"));

			log.info("Customers found with findAll():");
			for (Users user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

		};
	}


}
