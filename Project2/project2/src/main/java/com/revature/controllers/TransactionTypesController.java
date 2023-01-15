package com.revature.controllers;

import com.revature.daos.TransactionTypesDAO;
import com.revature.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping()// TODO
public class TransactionTypesController {
    TransactionTypesDAO transactionTypesDAO;

    @Autowired
    public TransactionTypesController(TransactionTypesDAO transactionTypesDAO) {
        this.transactionTypesDAO = transactionTypesDAO;
    }

    public TransactionType getTransactionTypeById(int id) {
        Optional<TransactionType> transactionType = transactionTypesDAO.findById(id);
        return transactionType.get();
    }
}
