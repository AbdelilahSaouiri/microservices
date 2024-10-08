package net.ensah.customerservice.repository;

import net.ensah.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
     Customer findByCustomerId(String customerId);
}
