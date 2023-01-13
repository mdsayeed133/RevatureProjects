package com.revature.daos;

import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //Finished (Probably)
public interface TransactionsDAO extends JpaRepository<Transaction, Integer> {
    public Optional<List<Transaction>> findByAccountId(Account accountId);
    public Optional<List<Transaction>> findByAccountIdAndTransactionTypeId(Account accountId, TransactionType transactionTypeId);
}
