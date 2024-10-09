package net.ensah.accountservice;

import net.ensah.accountservice.Enum.AccountType;
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
	CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
		return args -> {
			BankAccount bankAccount1 =BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.accountType(AccountType.CURRENT_ACCOUNT)
					.balance(15009.67)
					.createdAt(LocalDate.now())
					.currency("MAD")
					.cutsomerId("1d202257-1ea6-4cb2-9da5-1d503239134b")
					.build();
			BankAccount bankAccount2 =BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.accountType(AccountType.SAVING_ACCOUNT)
					.balance(1509)
					.createdAt(LocalDate.now())
					.currency("MAD")
					.cutsomerId("1234")
					.build();
			BankAccount bankAccount3 =BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.accountType(AccountType.CURRENT_ACCOUNT)
					.balance(15009.67)
					.createdAt(LocalDate.now())
					.currency("USD")
					.cutsomerId(UUID.randomUUID().toString())
					.build();
			accountRepository.save(bankAccount1);
			accountRepository.save(bankAccount2);
			accountRepository.save(bankAccount3);
		};
	}

}
