package net.ensah.accountservice.service;

import net.ensah.accountservice.dto.Response.AccountResponseDto;
import net.ensah.accountservice.entity.BankAccount;
import net.ensah.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountResponseDto>  getAllAcounts(){
        List<BankAccount> bankAccounts = accountRepository.findAll();
        List<AccountResponseDto> accountResponseDtos = new ArrayList<>();
        for(BankAccount bankAccount : bankAccounts){
            AccountResponseDto accountResponseDto= AccountResponseDto.builder()
                    .accountId(bankAccount.getAccountId())
                    .accountType(bankAccount.getAccountType())
                    .balance(bankAccount.getBalance())
                    .currency(bankAccount.getCurrency())
                    .customerId(bankAccount.getCutsomerId())
                    .createdAt(bankAccount.getCreatedAt())
                    .build();
            accountResponseDtos.add(accountResponseDto);
        }
        return accountResponseDtos;
    }

    public AccountResponseDto getAccountById(Long accountId) {
        Optional<BankAccount> bankAccount = accountRepository.findById(accountId);
        return bankAccount.map(account -> AccountResponseDto.builder()
                .accountId(account.getAccountId())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .customerId(account.getCutsomerId())
                .createdAt(account.getCreatedAt())
                .build()).orElse(null);
    }
}
