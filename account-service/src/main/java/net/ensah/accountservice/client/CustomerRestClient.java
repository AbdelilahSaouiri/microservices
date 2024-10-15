package net.ensah.accountservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ensah.accountservice.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    Logger logger= LoggerFactory.getLogger(CustomerRestClient.class);

    @GetMapping("/api/customers/{customerId}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerByCustomerId(@PathVariable String customerId);

    @GetMapping("/api/customers")
    @CircuitBreaker(name = "listCustomerService", fallbackMethod = "getAllCustomers")
    List<Customer> getCustomers();

    default Customer getDefaultCustomer(String customerId, Throwable throwable) {
        logger.error("Fallback for getCustomerByCustomerId due to: {}", throwable.getMessage());
        return Customer.builder()
                .customerId(customerId)
                .firstname("default")
                .lastName("default")
                .email("default@email.com")
                .build();
    }

    default List<Customer> getAllCustomers(Throwable throwable) {
        logger.error("Fallback for getCustomers due to: {}", throwable.getMessage());
        return List.of();
    }
}
