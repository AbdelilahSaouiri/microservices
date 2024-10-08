package net.ensah.customerservice.controller;

import net.ensah.customerservice.dto.request.CustomerRequestDto;
import net.ensah.customerservice.dto.response.CustomerResponseDto;
import net.ensah.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
     @GetMapping
     public ResponseEntity<?>   allCustomers() {
         List<CustomerResponseDto> users = customerService.getAllUsers();
         return ResponseEntity.ok(users);
     }
     @PostMapping
     public ResponseEntity<?>  addNewCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
         CustomerResponseDto customerResponseDto = customerService.addNewCustomer(customerRequestDto);
         return ResponseEntity.ok(customerResponseDto);
     }

     @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerId) {
         CustomerResponseDto customer = customerService.findCustomerbyCustomerId(customerId);
         return ResponseEntity.ok(customer);
     }
}
