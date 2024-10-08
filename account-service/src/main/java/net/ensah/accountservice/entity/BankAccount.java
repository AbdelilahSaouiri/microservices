package net.ensah.accountservice.entity;

import jakarta.persistence.*;
import lombok.*;
import net.ensah.accountservice.Enum.AccountType;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String cutsomerId;

}
