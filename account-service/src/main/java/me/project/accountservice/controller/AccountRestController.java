package me.project.accountservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import me.project.accountservice.client.CustomerRestClient;
import me.project.accountservice.entities.BankAccount;
import me.project.accountservice.model.Customer;
import me.project.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        bankAccounts.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        });
        return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount findByAccountId(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());

        bankAccount.setCustomer(customer);
        return bankAccount;

    }
}
