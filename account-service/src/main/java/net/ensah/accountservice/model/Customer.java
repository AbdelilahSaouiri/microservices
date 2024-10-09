package net.ensah.accountservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Customer {
    private String customerId;
    private String firstname;
    private String lastName;
    private String email;
}

