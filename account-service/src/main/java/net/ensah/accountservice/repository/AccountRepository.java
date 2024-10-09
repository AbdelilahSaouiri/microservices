package net.ensah.accountservice.repository;

import net.ensah.accountservice.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount,Long> {
     BankAccount findByAccountId(String accountId);

}
