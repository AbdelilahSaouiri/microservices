package net.ensah.accountservice;

import net.ensah.accountservice.Enum.AccountType;
import net.ensah.accountservice.client.CustomerRestClient;
import net.ensah.accountservice.entity.BankAccount;
import net.ensah.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
		return args -> customerRestClient.getCustomers().forEach(c->{
            BankAccount bankAccount1 =BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .accountType(AccountType.CURRENT_ACCOUNT)
                    .balance(15009.67)
                    .createdAt(LocalDate.now())
                    .currency("MAD")
                    .cutsomerId(c.getCustomerId())
                    .build();
             accountRepository.save(bankAccount1);
        });
	}

}
