package com.revature.daos;

import com.revature.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsDAO extends JpaRepository<Transaction, Integer> {
    public Optional<List<Transaction>> findByAccount(int accountId);
    public Optional<List<Transaction>> findByAccountAndType(int accountId, int transactionTypeId);
}