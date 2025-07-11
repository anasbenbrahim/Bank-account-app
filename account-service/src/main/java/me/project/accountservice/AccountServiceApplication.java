package me.project.accountservice;

import me.project.accountservice.client.CustomerRestClient;
import me.project.accountservice.entities.BankAccount;
import me.project.accountservice.enums.AccountType;
import me.project.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			BankAccountRepository bankAccountRepository,
			CustomerRestClient customerRestClient
	) {
		return args -> {
			customerRestClient.findAllCustomers().forEach(customer -> {
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*80000)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(customer.getId())
						.build();

				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(Math.random()*65432)
						.createAt(LocalDate.now())
						.type(AccountType.SAVINGS_ACCOUNT)
						.customerId(customer.getId())
						.build();

				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);
			});

		};
	}

}
