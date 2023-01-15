package com.revature.controllers;

import com.revature.daos.AccountsDAO;
import com.revature.models.Account;
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
    @Autowired
    public AccountController(AccountsDAO accountsDAO) {
        this.accountsDAO = accountsDAO;
    }

    @PutMapping("/{id}/amount")
    public ResponseEntity<String> updateAmount(@PathVariable int id, @RequestParam double amount) {
        if(accountsDAO.updateAmount(id, amount))
            return ResponseEntity.ok().body("Amount updated successfully");
        else
            return ResponseEntity.badRequest().body("Failed to update amount");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUser(@PathVariable int userId) {
        Optional<List<Account>> accounts = accountsDAO.findByUser(userId);
        if (accounts.isPresent()) {
            return ResponseEntity.ok(accounts.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
