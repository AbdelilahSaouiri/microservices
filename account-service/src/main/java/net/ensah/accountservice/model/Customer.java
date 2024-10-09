package net.ensah.accountservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Customer {
    private String customerId;
    private String firstname;
    private String lastName;
    private String email;
}

