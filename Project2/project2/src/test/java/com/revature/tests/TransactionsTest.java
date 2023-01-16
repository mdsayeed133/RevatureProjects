package com.revature.tests;

import com.revature.controllers.TransactionsController;
import com.revature.daos.TransactionsDAO;
import com.revature.models.*;
import com.revature.services.AccountService;
import com.revature.services.TransactionTypeService;
import com.revature.services.TransactionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    private TransactionTypeService transactionTypeService;

    @InjectMocks
    private TransactionsService transactionsService;
    @InjectMocks
    private TransactionsController transactionsController;

    private AccountType accountType;
    private Account account;
    private TransactionType transactionType;
    private Transaction transaction;
    private User user;

    @BeforeEach
    public void setup(){
        user = new User(1, "username", "password", "firstName", "lastName", "address", "email");
        accountType = new AccountType(1,"checking");
        account = new Account(1,user,500,accountType);
        transactionType = new TransactionType(1,"expense");
        transaction = new Transaction(1,account,500,"Gimme yo money",transactionType);
    }

    @Test
    public void createTransaction_ThrowsException_WhenUpdatingAmountFails() {
        when(accountService.getAmountOfAccount(1)).thenReturn(500.0);
        when(transactionTypeService.getTransactionTypeById(1)).thenReturn(transactionType);
        when(accountService.updateAmount(1, 500)).thenReturn(false);

        //Verify that the createTransaction method throws an exception
        assertThrows(Exception.class, () -> transactionsService.createTransaction(transaction));
    }

    /*
    @Test //assert that this should work.
    public void addTransactionTest() throws Exception {
        //when(accountService.getAmountOfAccount(anyInt())).thenReturn(200.0);
        when(transactionTypeService.getTransactionTypeById(anyInt())).thenReturn(transactionType);
        //when(accountService.updateAmount(anyInt(), anyInt())).thenReturn(true);
        when(transactionsService.createTransaction(transaction)).thenReturn(transaction);
        ResponseEntity<Transaction> response = transactionsController.addTransaction(transaction);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(),transaction);
        assertEquals(1,1);
    }
    */
    @Test
    public void createTransaction_ReturnsTransaction_WhenUpdatingAmountSucceeds() throws Exception {
        when(transactionsDAO.save(transaction)).thenReturn(transaction);
        when(accountService.getAmountOfAccount(0)).thenReturn(500.0);
        when(accountService.updateAmount(0, 0)).thenReturn(true);
        when(transactionTypeService.getTransactionTypeById(1)).thenReturn(transactionType);

        Transaction result = transactionsService.createTransaction(transaction);

        assertEquals(transaction,result);
    }


}