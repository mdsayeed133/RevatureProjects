package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.models.Account;
import com.revature.models.AccountDTO;
import com.revature.models.User;
import com.revature.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {
    private AccountsDAO accountsDAO;
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService, AccountsDAO accountsDAO){
        this.accountService= accountService;
        this.accountsDAO = accountsDAO;
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUser(@PathVariable int userId) {
        Optional<List<Account>> accounts = accountService.getAccountOfUser(userId);
        if (accounts.isPresent()) {
            return ResponseEntity.ok(accounts.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/user/{userId}/type/{type}")
    public ResponseEntity<List<Account>> getAccountsByUserAndType(@PathVariable int userId, @PathVariable int type) {
        Optional<List<Account>> accounts = accountService.getAccountOfUserAndType(userId,type);
        if (accounts.isPresent()) {
            return ResponseEntity.ok(accounts.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Account> addAccount(@RequestBody AccountDTO account) {
        try {
            return ResponseEntity.ok(accountService.createAccount(account));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
