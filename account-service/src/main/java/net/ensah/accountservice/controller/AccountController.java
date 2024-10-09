package net.ensah.accountservice.controller;

import net.ensah.accountservice.dto.Response.AccountResponseDto;
import net.ensah.accountservice.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<?>  getAllAccounts() {
        List<AccountResponseDto> allAcounts = accountService.getAllAcounts();
        return ResponseEntity.ok(allAcounts);
    }

   @GetMapping("/{accountId}")
    public ResponseEntity<?>  getAccountById(@PathVariable String accountId) {
       AccountResponseDto accountById = accountService.getAccountById(accountId);
       return ResponseEntity.ok(accountById);
   }
}
