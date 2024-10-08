package net.ensah.customerservice.service;

import net.ensah.customerservice.dto.request.CustomerRequestDto;
import net.ensah.customerservice.dto.response.CustomerResponseDto;
import net.ensah.customerservice.entity.Customer;
import net.ensah.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDto> getAllUsers(){
        List<Customer> customerRepositoryAll = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for (Customer customer : customerRepositoryAll) {
            CustomerResponseDto customerResponseDto=CustomerResponseDto.builder()
                    .customerId(customer.getCustomerId())
                    .firstname(customer.getFirstName())
                    .lastName(customer.getLastName())
                    .email(customer.getEmail())
                    .build();
            customerResponseDtoList.add(customerResponseDto);
        }
        return customerResponseDtoList;
    }

    public CustomerResponseDto addNewCustomer(CustomerRequestDto customerRequestDto) {
             Customer customer = Customer.builder()
                     .customerId(UUID.randomUUID().toString())
                     .firstName(customerRequestDto.firstName())
                     .lastName(customerRequestDto.lastName())
                     .email(customerRequestDto.email())
                     .build();
        Customer saved = customerRepository.save(customer);
       return CustomerResponseDto.builder()
                .firstname(saved.getFirstName())
                .lastName(saved.getLastName())
                .email(saved.getEmail())
                .build();
       
    }

    public CustomerResponseDto findCustomerbyCustomerId(String customerId) {
        Customer byCustomerId = customerRepository.findByCustomerId(customerId);
       return CustomerResponseDto.builder()
                .firstname(byCustomerId.getFirstName())
                .lastName(byCustomerId.getLastName())
                .email(byCustomerId.getEmail())
                .build();

    }
}
