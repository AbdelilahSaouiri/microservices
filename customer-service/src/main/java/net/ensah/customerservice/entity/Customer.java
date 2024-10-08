package net.ensah.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor  @AllArgsConstructor @Builder
public class Customer {
   @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
}
