package com.revature.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.revature.daos.TransactionsDAO;
import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.models.Transaction;
import com.revature.models.TransactionType;
import com.revature.services.AccountService;
import com.revature.services.TransactionTypeService;
import com.revature.services.TransactionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    private AccountType accountType= mock(AccountType.class);
    private Account account = mock(Account.class);
    private TransactionType transactionType = mock(TransactionType.class);
    private Transaction transaction = mock(Transaction.class);

    @BeforeEach
    public void setup(){
        //TODO
    }

    @Test
    public void createTransaction_ShouldThrowException_WhenUpdatingAmountFails() {

        //when(accountService.getAmountOfAccount(anyInt())).thenReturn(200.0);
       // when(transactionTypeService.getTransactionTypeById(anyInt())).thenReturn(transactionType);
       // when(accountService.updateAmount(anyInt(), anyInt())).thenReturn(false);

        // Verify that the createTransaction method throws an exception
        assertThrows(Exception.class, () -> transactionsService.createTransaction(transaction));
    }
}