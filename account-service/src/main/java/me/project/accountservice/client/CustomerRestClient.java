package me.project.accountservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import me.project.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    @GetMapping("/customers")
    List<Customer> findAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Valid");
        customer.setLastName("Not Valid");
        customer.setEmail("Not Valid");
        return customer;
    }

    default List<Customer> getDefaultCustomers(Exception exception){
        return List.of();
    }


}
