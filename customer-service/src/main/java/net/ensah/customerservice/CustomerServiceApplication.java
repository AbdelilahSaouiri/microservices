package net.ensah.customerservice;

import net.ensah.customerservice.entity.Customer;
import net.ensah.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer customer1= Customer.builder()
                    .customerId("1d202257-1ea6-4cb2-9da5-1d503239134b")
                    .firstName("abdelilah")
                    .lastName("saouiri")
                    .email("abdelilah@gmail.com")
                    .build();
            Customer customer2= Customer.builder()
                    .customerId("1667d202257-1ea6-4cb2-9da5-1d503239134b")
                    .firstName("said")
                    .lastName("wahbi")
                    .email("said@gmail.com")
                    .build();
            Customer customer3= Customer.builder()
                    .customerId("1234")
                    .firstName("fes")
                    .lastName("halima")
                    .email("halima@gmail.com")
                    .build();
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
        };
    }
}
