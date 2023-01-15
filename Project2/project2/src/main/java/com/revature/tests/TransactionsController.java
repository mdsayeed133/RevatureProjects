package com.revature.tests;

import com.revature.daos.TransactionsDAO;
import com.revature.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionsController {
    private TransactionsDAO transactionsDAO;

    @Autowired
    public TransactionsController(TransactionsDAO transactionsDAO) {
        this.transactionsDAO = transactionsDAO;
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(@PathVariable int accountId) {
        Optional<List<Transaction>> transactions = transactionsDAO.findByAccount(accountId);
        if (transactions.isPresent()) {
            return ResponseEntity.ok(transactions.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/account/{accountId}/type/{typeId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountAndType(@PathVariable int accountId, @PathVariable int typeId) {
        Optional<List<Transaction>> transactions = transactionsDAO.findByAccountAndType(accountId, typeId);
        if (transactions.isPresent()) {
            return ResponseEntity.ok(transactions.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        try {
            return ResponseEntity.ok(transactionsDAO.save(transaction));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
