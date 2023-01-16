package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.revature.daos.TransactionTypesDAO;
import com.revature.models.TransactionType;
import com.revature.services.TransactionTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TransactionTypesTest {
    @InjectMocks
    private TransactionTypeService transactionTypeService;
    @Mock
    private TransactionTypesDAO transactionTypesDAO;

    @Test
    public void testGetType(){
        TransactionType type = new TransactionType(1,"expense");
        when(transactionTypesDAO.findById(1)).thenReturn(Optional.of(type));
        TransactionType response= transactionTypeService.getTransactionTypeById(1);
        assertEquals(response.getTransactionTypesName(),"expense");
    }
}
