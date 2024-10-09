package net.ensah.accountservice.dto.Response;

import lombok.Builder;
import net.ensah.accountservice.Enum.AccountType;

import java.time.LocalDate;
@Builder
public record AccountResponseDto (
        String accountId, double balance, LocalDate createdAt,
        String currency, AccountType accountType,String customerId){
}
