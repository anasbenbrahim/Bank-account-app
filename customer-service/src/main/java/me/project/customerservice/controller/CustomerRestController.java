package me.project.customerservice.controller;

import lombok.RequiredArgsConstructor;
import me.project.customerservice.entities.Customer;
import me.project.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}
