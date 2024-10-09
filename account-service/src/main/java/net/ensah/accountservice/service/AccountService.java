package net.ensah.accountservice.service;

import net.ensah.accountservice.client.CustomerRestClient;
import net.ensah.accountservice.dto.Response.AccountResponseDto;
import net.ensah.accountservice.entity.BankAccount;
import net.ensah.accountservice.model.Customer;
import net.ensah.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public AccountService(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
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
                    .customer(customerRestClient.getCustomerByCustomerId(bankAccount.getCutsomerId()))
                    .build();
            accountResponseDtos.add(accountResponseDto);
        }
        return accountResponseDtos;
    }

    public AccountResponseDto getAccountById(String accountId) {
        BankAccount bankAccount = accountRepository.findByAccountId(accountId);
        Customer customerByCustomerId = customerRestClient.getCustomerByCustomerId(bankAccount.getCutsomerId());
        return AccountResponseDto.builder()
                .accountId(bankAccount.getAccountId())
                .accountType(bankAccount.getAccountType())
                .balance(bankAccount.getBalance())
                .currency(bankAccount.getCurrency())
                .customerId(bankAccount.getCutsomerId())
                .createdAt(bankAccount.getCreatedAt())
                .customer(customerByCustomerId)
                .build();
    }

  
}
