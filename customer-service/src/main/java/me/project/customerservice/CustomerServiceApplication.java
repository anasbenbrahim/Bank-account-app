package me.project.customerservice;

import me.project.customerservice.entities.Customer;
import me.project.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customers = List.of(
					Customer.builder()
							.firstName("John")
							.lastName("Doe")
							.email("john@gmail.com")
							.build(),
					Customer.builder()
						.firstName("Anas")
						.lastName("Ben ibrahim")
						.email("anas@gmail.com")
						.build()
			);
			customerRepository.saveAll(customers);
		};
	}

}
