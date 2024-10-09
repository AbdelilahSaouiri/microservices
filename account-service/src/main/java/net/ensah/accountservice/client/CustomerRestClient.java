package net.ensah.accountservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ensah.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{customerId}")
    @CircuitBreaker(name = "customerSerive",fallbackMethod = "getDefaultCustomer")
    Customer getCustomerByCustomerId(@PathVariable String customerId);

    @GetMapping("/api/customers")
    @CircuitBreaker(name = "ListCustomerSerivce",fallbackMethod = "getAllCustomers")
    List<Customer> getCustomers();

    default Customer getDefaultCustomer(String customerId) {
        return Customer.builder()
                .customerId(customerId)
                .firstname("default")
                .lastName("default")
                .email("default@email.com")
                .build();
    }

    default List<Customer> getAllCustomers() {
        return List.of();
    }
}
