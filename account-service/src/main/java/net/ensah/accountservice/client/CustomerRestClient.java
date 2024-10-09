package net.ensah.accountservice.client;

import net.ensah.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{customerId}")
    Customer getCustomerByCustomerId(@PathVariable String customerId);
}
