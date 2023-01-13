package com.revature.controllers;

import com.revature.daos.TransactionTypesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping()//TODO
public class TransactionTypesController {
    TransactionTypesDAO transactionTypesDAO;

    @Autowired
    public TransactionTypesController(TransactionTypesDAO transactionTypesDAO) {
        this.transactionTypesDAO = transactionTypesDAO;
    }
}
