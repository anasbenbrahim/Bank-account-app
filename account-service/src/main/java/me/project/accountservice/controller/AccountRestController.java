package me.project.accountservice.controller;

import lombok.RequiredArgsConstructor;
import me.project.accountservice.entities.BankAccount;
import me.project.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final BankAccountRepository bankAccountRepository;

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount findByAccountId(@PathVariable String id){
        return bankAccountRepository.findById(id).get();
    }
}
