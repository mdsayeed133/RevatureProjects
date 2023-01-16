package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

    private AccountType accountType= mock(AccountType.class);
    private Account account = mock(Account.class);
    private TransactionType transactionType = mock(TransactionType.class);
    private Transaction transaction = mock(Transaction.class);
    private User user = mock(User.class);

    @BeforeEach
    public void setup(){
        user = new User(1, "username", "password", "firstName", "lastName", "address", "email");
        accountType = new AccountType(1,"checking");
        account = new Account(1,user,500,accountType);
        transactionType = new TransactionType(1,"expense");
        transaction = new Transaction(1,account,500,"Gimme yo money",transactionType);
        //TODO
    }

    @Test
    public void createTransaction_ShouldThrowException_WhenUpdatingAmountFails() {

        when(accountService.getAmountOfAccount(anyInt())).thenReturn(200.0);
        when(transactionTypeService.getTransactionTypeById(anyInt())).thenReturn(transactionType);
        when(accountService.updateAmount(anyInt(), anyInt())).thenReturn(false);

        //Verify that the createTransaction method throws an exception
        assertThrows(Exception.class, () -> transactionsService.createTransaction(transaction));
    }

    @Test //assert that this should work.
    public void addTransactionTest() throws Exception {
        //when(accountService.getAmountOfAccount(anyInt())).thenReturn(200.0);
        when(transactionTypeService.getTransactionTypeById(anyInt())).thenReturn(transactionType);
        when(accountService.updateAmount(anyInt(), anyInt())).thenReturn(true);
        when(transactionsService.createTransaction(transaction)).thenReturn(transaction);
        ResponseEntity<Transaction> response = transactionsController.addTransaction(transaction);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(),transaction);
    }


}