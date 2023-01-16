package com.revature.tests;

import com.revature.controllers.TransactionsController;
import com.revature.daos.AccountsDAO;
import com.revature.daos.TransactionsDAO;
import com.revature.models.*;
import com.revature.services.AccountService;
import com.revature.services.TransactionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionsTest {
    @Mock
    private TransactionsDAO transactionsDAO;
    @Mock
    private AccountService accountService;
    @Mock
    private TransactionsService transactionsService;

    @InjectMocks
    private TransactionsController transactionsController;

    private AccountType accountType;
    private Account account;
    private TransactionType transactionType;
    private Transaction transaction;
    private User user;
    private List<Transaction> transactions;
    private TransactionDTO transactionDTO;

    @BeforeEach
    public void setup() {
        user = new User(1, "username", "password", "firstName", "lastName", "address", "email");
        accountType = new AccountType(1,"checking");
        account = new Account(1,user,500,accountType);
        transactionType = new TransactionType(1,"expense");
        transaction = new Transaction(1,account,500,"Gimme yo money",transactionType);
        transactions = new ArrayList<>();
        transactions.add(transaction);
        transactionDTO = new TransactionDTO(100,"Test transaction",1);
    }

    @Test
    public void getTransactionsByAccount_ReturnsTransactions_WhenTransactionsExist() {
        when(transactionsService.getListOfTransactionByAccountId(1)).thenReturn(Optional.of(transactions));

        ResponseEntity<List<Transaction>> response = transactionsController.getTransactionsByAccount(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transactions, response.getBody());
    }

    @Test
    public void getTransactionsByAccount_ReturnsNotFound_WhenTransactionsDoNotExist() {
        when(transactionsService.getListOfTransactionByAccountId(1)).thenReturn(Optional.empty());

        ResponseEntity<List<Transaction>> response = transactionsController.getTransactionsByAccount(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void getTransactionsByAccountAndType_ReturnsTransactions_WhenTransactionsExist() {
        when(transactionsService.getListOfTransactionByAccountIdAndTypeId(1, 1)).thenReturn(Optional.of(transactions));

        ResponseEntity<List<Transaction>> response = transactionsController.getTransactionsByAccountAndType(1, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transactions, response.getBody());
    }

    @Test
    public void getTransactionsByAccountAndType_ReturnsNotFound_WhenTransactionsDoNotExist() {
        when(transactionsService.getListOfTransactionByAccountIdAndTypeId(1, 1)).thenReturn(Optional.empty());

        ResponseEntity<List<Transaction>> response = transactionsController.getTransactionsByAccountAndType(1, 1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void addTransaction_ReturnsTransaction_WhenTransactionIsSuccessful() throws Exception {
        when(transactionsService.createTransaction(transactionDTO)).thenReturn(transaction);
        ResponseEntity<Transaction> result = transactionsController.addTransaction(transactionDTO);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(transaction, result.getBody());
    }



}