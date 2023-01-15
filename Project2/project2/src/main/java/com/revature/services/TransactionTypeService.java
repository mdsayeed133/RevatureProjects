package com.revature.services;

import com.revature.daos.TransactionTypesDAO;
import com.revature.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TransactionTypeService {

    private TransactionTypesDAO transactionTypesDAO;

    @Autowired
    public TransactionTypeService(TransactionTypesDAO transactionTypesDAO) {
        this.transactionTypesDAO = transactionTypesDAO;
    }

    public TransactionType getTransactionTypeById(int id) {
        Optional<TransactionType> transactionType = transactionTypesDAO.findById(id);
        return transactionType.get();
    }
}
